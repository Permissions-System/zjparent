package com.zjgt.p2p.manage.base.shiro;

import java.io.Serializable;

import org.apache.shiro.authz.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.StringUtils;

/**
 * 授权信息
 * 
 * @author xrwang
 * 
 */
public class SimplePermission implements Permission, Serializable {
    private static Logger logger = LoggerFactory.getLogger(SimplePermission.class);
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final int CHECK_TYPE_URI = 1;// 按请求资源
    private static final int CHECK_TYPE_CODE = 2;// 按请求资源编号
    private static final int CHECK_TYPE_BOTH = 3;// 两者都通过
    private static final int CHECK_TYPE_ASWILL = 4;// 两者任一通过
    private static final boolean DEFAULT_CASE_SENSITIVE = true;// 区分大小写

    private static final String URI_ASTERISK_WILDCARD = "/**";// 通配符
    private static final String URI_SEPARATIVE_SIGN = "/";// URI分隔符
    private static final char URI_SEPARATIVE_SIGN_CHAR = '/';// URI分隔符
    private static final String REST_PARAM_PLACEHOLDER_REX = "{*}";// REST风格URI参数占位通配符
    private static final String REST_PARAM_PLACEHOLDER = URI_SEPARATIVE_SIGN
            + REST_PARAM_PLACEHOLDER_REX;// REST风格URI参数占位符

    private String uri; // 资源URI
    private String code;// 资源编号
    private int checkType = CHECK_TYPE_URI;// 验证类型,默认按照请求资源

    public SimplePermission(String uri, String code) {
        logger.debug("create SimplePermission, uri:" + uri + ", code:" + code);
        String localUri = (StringUtils.isEmpty(uri) ? null : uri.trim());
        if (localUri != null) {
            // 整理URI路径格式为: /home/base/list
            if (localUri.charAt(0) != URI_SEPARATIVE_SIGN_CHAR) {
                localUri = URI_SEPARATIVE_SIGN + localUri;
            }
            // 排除URI="/"
            if (localUri.length() > 1
                    && localUri.charAt(localUri.length() - 1) == URI_SEPARATIVE_SIGN_CHAR) {
                localUri = localUri.substring(0, localUri.length() - 1);
            }
        }
        String localCode = (StringUtils.isEmpty(code) ? null : code.trim());
        if (localUri == null && localCode == null) {
            throw new BusinessException("授权信息异常");
        } else if (localUri == null) {
            this.checkType = CHECK_TYPE_CODE;
            if (DEFAULT_CASE_SENSITIVE) {
                this.code = localCode;
            } else {
                this.code = localCode.toLowerCase();
            }
        } else if (localCode == null) {
            this.checkType = CHECK_TYPE_URI;
            if (DEFAULT_CASE_SENSITIVE) {
                this.uri = localUri;
            } else {
                this.uri = localUri.toLowerCase();
            }
        } else {
            this.checkType = CHECK_TYPE_ASWILL;
            if (DEFAULT_CASE_SENSITIVE) {
                this.uri = localUri;
                this.code = localCode;
            } else {
                this.uri = localUri.toLowerCase();
                this.code = localCode.toLowerCase();
            }
        }
        logger.debug("create SimplePermission, uri:" + this.uri + ", code:" + this.code);
    }

    @Override
    public boolean implies(Permission p) {
        if (!(p instanceof SimplePermission)) {
            return false;
        } else if (this == p) {
            return true;
        }

        SimplePermission sp = (SimplePermission) p;
        boolean result = false;
        if (this.checkType != sp.getCheckType() && this.checkType != CHECK_TYPE_ASWILL) {
            // 没有可比性
            result = false;
        } else if (sp.getCheckType() == CHECK_TYPE_URI) {
            result = compareUri(sp);
        } else if (sp.getCheckType() == CHECK_TYPE_CODE) {
            result = this.code.equals(sp.getCode());
        } else if (sp.getCheckType() == CHECK_TYPE_BOTH) {
            result = (compareUri(sp) && this.code.equals(sp.getCode()));
        } else if (sp.getCheckType() == CHECK_TYPE_ASWILL) {
            result = (compareUri(sp) || this.code.equals(sp.getCode()));
        } else {
            throw new BusinessException("权限控制码异常");
        }
        if (result) {
            logger.debug("\timplies pass:" + this.toString());
        }
        return result;
    }

    /**
     * 对比请求资源是否一致
     * 
     * @param sp
     * @return
     */
    private boolean compareUri(SimplePermission sp) {
        // 支持/**通配符
        if (this.uri.endsWith(URI_ASTERISK_WILDCARD)) {
            String localUri = this.uri.substring(0, this.uri.indexOf(URI_ASTERISK_WILDCARD));
            String reqUri = sp.getUri();
            reqUri = reqUri.substring(0, reqUri.lastIndexOf(URI_SEPARATIVE_SIGN));
            return localUri.equals(reqUri);
        }
        // 支持REST风格参数请求
        if (this.uri.contains(REST_PARAM_PLACEHOLDER)) {
            String[] localUris = this.uri.split(URI_SEPARATIVE_SIGN);
            String[] uris = sp.getUri().split(URI_SEPARATIVE_SIGN);
            if (localUris.length != uris.length) {
                return false;
            } else {
                for (int i = 0; i < localUris.length; i++) {
                    if (!localUris[i].equals(REST_PARAM_PLACEHOLDER_REX)
                            && !localUris[i].equals(uris[i])) {
                        return false;
                    }
                }
            }
            return true;
        }
        return this.uri.equals(sp.getUri());
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCheckType() {
        return checkType;
    }

    public void setCheckType(int checkType) {
        this.checkType = checkType;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(this.uri);
        buffer.append(":");
        buffer.append(this.code);
        buffer.append(":");
        buffer.append(this.checkType);
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SimplePermission) {
            SimplePermission sp = (SimplePermission) o;
            return (this == sp || this.toString().equals(sp.toString()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (uri == null ? 0 : uri.hashCode()) + (code == null ? 0 : code.hashCode())
                + checkType;
    }
}

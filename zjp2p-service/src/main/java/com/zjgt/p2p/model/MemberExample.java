package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class MemberExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MemberExample()
  {
    this.oredCriteria = new ArrayList();
  }

  public void setOrderByClause(String orderByClause)
  {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause()
  {
    return this.orderByClause;
  }

  public void setDistinct(boolean distinct)
  {
    this.distinct = distinct;
  }

  public boolean isDistinct()
  {
    return this.distinct;
  }

  public List<Criteria> getOredCriteria()
  {
    return this.oredCriteria;
  }

  public void or(Criteria criteria)
  {
    this.oredCriteria.add(criteria);
  }

  public Criteria or()
  {
    Criteria criteria = createCriteriaInternal();
    this.oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria()
  {
    Criteria criteria = createCriteriaInternal();
    if (this.oredCriteria.size() == 0) {
      this.oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal()
  {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear()
  {
    this.oredCriteria.clear();
    this.orderByClause = null;
    this.distinct = false;
  }

  public static class Criterion
  {
    private String condition;
    private Object value;
    private Object secondValue;
    private boolean noValue;
    private boolean singleValue;
    private boolean betweenValue;
    private boolean listValue;
    private String typeHandler;

    public String getCondition()
    {
      return this.condition;
    }

    public Object getValue() {
      return this.value;
    }

    public Object getSecondValue() {
      return this.secondValue;
    }

    public boolean isNoValue() {
      return this.noValue;
    }

    public boolean isSingleValue() {
      return this.singleValue;
    }

    public boolean isBetweenValue() {
      return this.betweenValue;
    }

    public boolean isListValue() {
      return this.listValue;
    }

    public String getTypeHandler() {
      return this.typeHandler;
    }

    protected Criterion(String condition)
    {
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler)
    {
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if (value instanceof List)
        this.listValue = true;
      else
        this.singleValue = true;
    }

    protected Criterion(String condition, Object value)
    {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
    {
      this.condition = condition;
      this.value = value;
      this.secondValue = secondValue;
      this.typeHandler = typeHandler;
      this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
      this(condition, value, secondValue, null);
    }
  }

  public static class Criteria extends MemberExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MemberExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MemberExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MemberExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MemberExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MemberExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MemberExample.Criterion(condition, value1, value2));
    }

    public MemberExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameIsNull() {
      addCriterion("username is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameIsNotNull() {
      addCriterion("username is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameEqualTo(String value) {
      addCriterion("username =", value, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameNotEqualTo(String value) {
      addCriterion("username <>", value, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameGreaterThan(String value) {
      addCriterion("username >", value, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameGreaterThanOrEqualTo(String value) {
      addCriterion("username >=", value, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameLessThan(String value) {
      addCriterion("username <", value, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameLessThanOrEqualTo(String value) {
      addCriterion("username <=", value, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameLike(String value) {
      addCriterion("username like", value, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameNotLike(String value) {
      addCriterion("username not like", value, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameIn(List<String> values) {
      addCriterion("username in", values, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameNotIn(List<String> values) {
      addCriterion("username not in", values, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameBetween(String value1, String value2) {
      addCriterion("username between", value1, value2, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsernameNotBetween(String value1, String value2) {
      addCriterion("username not between", value1, value2, "username");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailIsNull() {
      addCriterion("email is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailIsNotNull() {
      addCriterion("email is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailEqualTo(String value) {
      addCriterion("email =", value, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailNotEqualTo(String value) {
      addCriterion("email <>", value, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailGreaterThan(String value) {
      addCriterion("email >", value, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
      addCriterion("email >=", value, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailLessThan(String value) {
      addCriterion("email <", value, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailLessThanOrEqualTo(String value) {
      addCriterion("email <=", value, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailLike(String value) {
      addCriterion("email like", value, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailOrMobileLike(String value) {
      addCriterion("(email like '" + value + "' or mobile like '" + value + "' )");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailNotLike(String value) {
      addCriterion("email not like", value, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailIn(List<String> values) {
      addCriterion("email in", values, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailNotIn(List<String> values) {
      addCriterion("email not in", values, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailBetween(String value1, String value2) {
      addCriterion("email between", value1, value2, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andEmailNotBetween(String value1, String value2) {
      addCriterion("email not between", value1, value2, "email");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordIsNull() {
      addCriterion("password is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordIsNotNull() {
      addCriterion("password is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordEqualTo(String value) {
      addCriterion("password =", value, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordNotEqualTo(String value) {
      addCriterion("password <>", value, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordGreaterThan(String value) {
      addCriterion("password >", value, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordGreaterThanOrEqualTo(String value) {
      addCriterion("password >=", value, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordLessThan(String value) {
      addCriterion("password <", value, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordLessThanOrEqualTo(String value) {
      addCriterion("password <=", value, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordLike(String value) {
      addCriterion("password like", value, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordNotLike(String value) {
      addCriterion("password not like", value, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordIn(List<String> values) {
      addCriterion("password in", values, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordNotIn(List<String> values) {
      addCriterion("password not in", values, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordBetween(String value1, String value2) {
      addCriterion("password between", value1, value2, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPasswordNotBetween(String value1, String value2) {
      addCriterion("password not between", value1, value2, "password");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameIsNull() {
      addCriterion("nickname is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameIsNotNull() {
      addCriterion("nickname is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameEqualTo(String value) {
      addCriterion("nickname =", value, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameNotEqualTo(String value) {
      addCriterion("nickname <>", value, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameGreaterThan(String value) {
      addCriterion("nickname >", value, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameGreaterThanOrEqualTo(String value) {
      addCriterion("nickname >=", value, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameLessThan(String value) {
      addCriterion("nickname <", value, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameLessThanOrEqualTo(String value) {
      addCriterion("nickname <=", value, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameLike(String value) {
      addCriterion("nickname like", value, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameNotLike(String value) {
      addCriterion("nickname not like", value, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameIn(List<String> values) {
      addCriterion("nickname in", values, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameNotIn(List<String> values) {
      addCriterion("nickname not in", values, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameBetween(String value1, String value2) {
      addCriterion("nickname between", value1, value2, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNicknameNotBetween(String value1, String value2) {
      addCriterion("nickname not between", value1, value2, "nickname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgIsNull() {
      addCriterion("headImg is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgIsNotNull() {
      addCriterion("headImg is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgEqualTo(String value) {
      addCriterion("headImg =", value, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgNotEqualTo(String value) {
      addCriterion("headImg <>", value, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgGreaterThan(String value) {
      addCriterion("headImg >", value, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgGreaterThanOrEqualTo(String value) {
      addCriterion("headImg >=", value, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgLessThan(String value) {
      addCriterion("headImg <", value, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgLessThanOrEqualTo(String value) {
      addCriterion("headImg <=", value, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgLike(String value) {
      addCriterion("headImg like", value, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgNotLike(String value) {
      addCriterion("headImg not like", value, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgIn(List<String> values) {
      addCriterion("headImg in", values, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgNotIn(List<String> values) {
      addCriterion("headImg not in", values, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgBetween(String value1, String value2) {
      addCriterion("headImg between", value1, value2, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andHeadimgNotBetween(String value1, String value2) {
      addCriterion("headImg not between", value1, value2, "headimg");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameIsNull() {
      addCriterion("realname is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameIsNotNull() {
      addCriterion("realname is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameEqualTo(String value) {
      addCriterion("realname =", value, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameNotEqualTo(String value) {
      addCriterion("realname <>", value, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameGreaterThan(String value) {
      addCriterion("realname >", value, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameGreaterThanOrEqualTo(String value) {
      addCriterion("realname >=", value, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameLessThan(String value) {
      addCriterion("realname <", value, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameLessThanOrEqualTo(String value) {
      addCriterion("realname <=", value, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameLike(String value) {
      addCriterion("realname like", value, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameNotLike(String value) {
      addCriterion("realname not like", value, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameIn(List<String> values) {
      addCriterion("realname in", values, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameNotIn(List<String> values) {
      addCriterion("realname not in", values, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameBetween(String value1, String value2) {
      addCriterion("realname between", value1, value2, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRealnameNotBetween(String value1, String value2) {
      addCriterion("realname not between", value1, value2, "realname");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameIsNull() {
      addCriterion("name is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameIsNotNull() {
      addCriterion("name is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameEqualTo(String value) {
      addCriterion("name =", value, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameNotEqualTo(String value) {
      addCriterion("name <>", value, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameGreaterThan(String value) {
      addCriterion("name >", value, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("name >=", value, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameLessThan(String value) {
      addCriterion("name <", value, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("name <=", value, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameLike(String value) {
      addCriterion("name like", value, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameNotLike(String value) {
      addCriterion("name not like", value, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameIn(List<String> values) {
      addCriterion("name in", values, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameNotIn(List<String> values) {
      addCriterion("name not in", values, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameBetween(String value1, String value2) {
      addCriterion("name between", value1, value2, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("name not between", value1, value2, "name");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailIsNull() {
      addCriterion("verifyemail is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailIsNotNull() {
      addCriterion("verifyemail is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailEqualTo(String value) {
      addCriterion("verifyemail =", value, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailNotEqualTo(String value) {
      addCriterion("verifyemail <>", value, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailGreaterThan(String value) {
      addCriterion("verifyemail >", value, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailGreaterThanOrEqualTo(String value) {
      addCriterion("verifyemail >=", value, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailLessThan(String value) {
      addCriterion("verifyemail <", value, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailLessThanOrEqualTo(String value) {
      addCriterion("verifyemail <=", value, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailLike(String value) {
      addCriterion("verifyemail like", value, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailNotLike(String value) {
      addCriterion("verifyemail not like", value, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailIn(List<String> values) {
      addCriterion("verifyemail in", values, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailNotIn(List<String> values) {
      addCriterion("verifyemail not in", values, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailBetween(String value1, String value2) {
      addCriterion("verifyemail between", value1, value2, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andVerifyemailNotBetween(String value1, String value2) {
      addCriterion("verifyemail not between", value1, value2, "verifyemail");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardIsNull() {
      addCriterion("idcard is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardIsNotNull() {
      addCriterion("idcard is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardEqualTo(String value) {
      addCriterion("idcard =", value, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardNotEqualTo(String value) {
      addCriterion("idcard <>", value, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardGreaterThan(String value) {
      addCriterion("idcard >", value, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardGreaterThanOrEqualTo(String value) {
      addCriterion("idcard >=", value, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardLessThan(String value) {
      addCriterion("idcard <", value, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardLessThanOrEqualTo(String value) {
      addCriterion("idcard <=", value, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardLike(String value) {
      addCriterion("idcard like", value, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardNotLike(String value) {
      addCriterion("idcard not like", value, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardIn(List<String> values) {
      addCriterion("idcard in", values, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardNotIn(List<String> values) {
      addCriterion("idcard not in", values, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardBetween(String value1, String value2) {
      addCriterion("idcard between", value1, value2, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIdcardNotBetween(String value1, String value2) {
      addCriterion("idcard not between", value1, value2, "idcard");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoIsNull() {
      addCriterion("bankcardno is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoIsNotNull() {
      addCriterion("bankcardno is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoEqualTo(String value) {
      addCriterion("bankcardno =", value, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoNotEqualTo(String value) {
      addCriterion("bankcardno <>", value, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoGreaterThan(String value) {
      addCriterion("bankcardno >", value, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoGreaterThanOrEqualTo(String value) {
      addCriterion("bankcardno >=", value, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoLessThan(String value) {
      addCriterion("bankcardno <", value, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoLessThanOrEqualTo(String value) {
      addCriterion("bankcardno <=", value, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoLike(String value) {
      addCriterion("bankcardno like", value, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoNotLike(String value) {
      addCriterion("bankcardno not like", value, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoIn(List<String> values) {
      addCriterion("bankcardno in", values, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoNotIn(List<String> values) {
      addCriterion("bankcardno not in", values, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoBetween(String value1, String value2) {
      addCriterion("bankcardno between", value1, value2, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnoNotBetween(String value1, String value2) {
      addCriterion("bankcardno not between", value1, value2, "bankcardno");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumIsNull() {
      addCriterion("bankcardnum is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumIsNotNull() {
      addCriterion("bankcardnum is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumEqualTo(Integer value) {
      addCriterion("bankcardnum =", value, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumNotEqualTo(Integer value) {
      addCriterion("bankcardnum <>", value, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumGreaterThan(Integer value) {
      addCriterion("bankcardnum >", value, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumGreaterThanOrEqualTo(Integer value) {
      addCriterion("bankcardnum >=", value, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumLessThan(Integer value) {
      addCriterion("bankcardnum <", value, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumLessThanOrEqualTo(Integer value) {
      addCriterion("bankcardnum <=", value, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumIn(List<Integer> values) {
      addCriterion("bankcardnum in", values, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumNotIn(List<Integer> values) {
      addCriterion("bankcardnum not in", values, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumBetween(Integer value1, Integer value2) {
      addCriterion("bankcardnum between", value1, value2, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBankcardnumNotBetween(Integer value1, Integer value2) {
      addCriterion("bankcardnum not between", value1, value2, "bankcardnum");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdIsNull() {
      addCriterion("transpasswd is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdIsNotNull() {
      addCriterion("transpasswd is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdEqualTo(String value) {
      addCriterion("transpasswd =", value, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdNotEqualTo(String value) {
      addCriterion("transpasswd <>", value, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdGreaterThan(String value) {
      addCriterion("transpasswd >", value, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdGreaterThanOrEqualTo(String value) {
      addCriterion("transpasswd >=", value, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdLessThan(String value) {
      addCriterion("transpasswd <", value, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdLessThanOrEqualTo(String value) {
      addCriterion("transpasswd <=", value, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdLike(String value) {
      addCriterion("transpasswd like", value, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdNotLike(String value) {
      addCriterion("transpasswd not like", value, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdIn(List<String> values) {
      addCriterion("transpasswd in", values, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdNotIn(List<String> values) {
      addCriterion("transpasswd not in", values, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdBetween(String value1, String value2) {
      addCriterion("transpasswd between", value1, value2, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdNotBetween(String value1, String value2) {
      addCriterion("transpasswd not between", value1, value2, "transpasswd");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetIsNull() {
      addCriterion("transpasswdifset is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetIsNotNull() {
      addCriterion("transpasswdifset is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetEqualTo(Integer value) {
      addCriterion("transpasswdifset =", value, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetNotEqualTo(Integer value) {
      addCriterion("transpasswdifset <>", value, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetGreaterThan(Integer value) {
      addCriterion("transpasswdifset >", value, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetGreaterThanOrEqualTo(Integer value) {
      addCriterion("transpasswdifset >=", value, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetLessThan(Integer value) {
      addCriterion("transpasswdifset <", value, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetLessThanOrEqualTo(Integer value) {
      addCriterion("transpasswdifset <=", value, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetIn(List<Integer> values) {
      addCriterion("transpasswdifset in", values, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetNotIn(List<Integer> values) {
      addCriterion("transpasswdifset not in", values, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetBetween(Integer value1, Integer value2) {
      addCriterion("transpasswdifset between", value1, value2, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andTranspasswdifsetNotBetween(Integer value1, Integer value2) {
      addCriterion("transpasswdifset not between", value1, value2, "transpasswdifset");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressIsNull() {
      addCriterion("address is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressIsNotNull() {
      addCriterion("address is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressEqualTo(String value) {
      addCriterion("address =", value, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressNotEqualTo(String value) {
      addCriterion("address <>", value, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressGreaterThan(String value) {
      addCriterion("address >", value, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
      addCriterion("address >=", value, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressLessThan(String value) {
      addCriterion("address <", value, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressLessThanOrEqualTo(String value) {
      addCriterion("address <=", value, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressLike(String value) {
      addCriterion("address like", value, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressNotLike(String value) {
      addCriterion("address not like", value, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressIn(List<String> values) {
      addCriterion("address in", values, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressNotIn(List<String> values) {
      addCriterion("address not in", values, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressBetween(String value1, String value2) {
      addCriterion("address between", value1, value2, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAddressNotBetween(String value1, String value2) {
      addCriterion("address not between", value1, value2, "address");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileIsNull() {
      addCriterion("mobile is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileIsNotNull() {
      addCriterion("mobile is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileEqualTo(String value) {
      addCriterion("mobile =", value, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileNotEqualTo(String value) {
      addCriterion("mobile <>", value, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileGreaterThan(String value) {
      addCriterion("mobile >", value, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileGreaterThanOrEqualTo(String value) {
      addCriterion("mobile >=", value, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileLessThan(String value) {
      addCriterion("mobile <", value, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileLessThanOrEqualTo(String value) {
      addCriterion("mobile <=", value, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileLike(String value) {
      addCriterion("mobile like", value, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileNotLike(String value) {
      addCriterion("mobile not like", value, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileIn(List<String> values) {
      addCriterion("mobile in", values, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileNotIn(List<String> values) {
      addCriterion("mobile not in", values, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileBetween(String value1, String value2) {
      addCriterion("mobile between", value1, value2, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMobileNotBetween(String value1, String value2) {
      addCriterion("mobile not between", value1, value2, "mobile");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountIsNull() {
      addCriterion("amount is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountIsNotNull() {
      addCriterion("amount is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("amount =", value, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("amount <>", value, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("amount >", value, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("amount >=", value, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("amount <", value, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("amount <=", value, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("amount in", values, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("amount not in", values, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount between", value1, value2, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount not between", value1, value2, "amount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthIsNull() {
      addCriterion("birth is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthIsNotNull() {
      addCriterion("birth is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthEqualTo(Date value) {
      addCriterion("birth =", value, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthNotEqualTo(Date value) {
      addCriterion("birth <>", value, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthGreaterThan(Date value) {
      addCriterion("birth >", value, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthGreaterThanOrEqualTo(Date value) {
      addCriterion("birth >=", value, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthLessThan(Date value) {
      addCriterion("birth <", value, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthLessThanOrEqualTo(Date value) {
      addCriterion("birth <=", value, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthIn(List<Date> values) {
      addCriterion("birth in", values, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthNotIn(List<Date> values) {
      addCriterion("birth not in", values, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthBetween(Date value1, Date value2) {
      addCriterion("birth between", value1, value2, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andBirthNotBetween(Date value1, Date value2) {
      addCriterion("birth not between", value1, value2, "birth");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderIsNull() {
      addCriterion("gender is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderIsNotNull() {
      addCriterion("gender is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderEqualTo(Integer value) {
      addCriterion("gender =", value, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderNotEqualTo(Integer value) {
      addCriterion("gender <>", value, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderGreaterThan(Integer value) {
      addCriterion("gender >", value, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderGreaterThanOrEqualTo(Integer value) {
      addCriterion("gender >=", value, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderLessThan(Integer value) {
      addCriterion("gender <", value, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderLessThanOrEqualTo(Integer value) {
      addCriterion("gender <=", value, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderIn(List<Integer> values) {
      addCriterion("gender in", values, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderNotIn(List<Integer> values) {
      addCriterion("gender not in", values, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderBetween(Integer value1, Integer value2) {
      addCriterion("gender between", value1, value2, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andGenderNotBetween(Integer value1, Integer value2) {
      addCriterion("gender not between", value1, value2, "gender");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberIsNull() {
      addCriterion("ifSelfMember is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberIsNotNull() {
      addCriterion("ifSelfMember is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberEqualTo(Boolean value) {
      addCriterion("ifSelfMember =", value, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberNotEqualTo(Boolean value) {
      addCriterion("ifSelfMember <>", value, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberGreaterThan(Boolean value) {
      addCriterion("ifSelfMember >", value, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberGreaterThanOrEqualTo(Boolean value) {
      addCriterion("ifSelfMember >=", value, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberLessThan(Boolean value) {
      addCriterion("ifSelfMember <", value, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberLessThanOrEqualTo(Boolean value) {
      addCriterion("ifSelfMember <=", value, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberIn(List<Boolean> values) {
      addCriterion("ifSelfMember in", values, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberNotIn(List<Boolean> values) {
      addCriterion("ifSelfMember not in", values, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberBetween(Boolean value1, Boolean value2) {
      addCriterion("ifSelfMember between", value1, value2, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfselfmemberNotBetween(Boolean value1, Boolean value2) {
      addCriterion("ifSelfMember not between", value1, value2, "ifselfmember");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceIsNull() {
      addCriterion("ifjoinExpence is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceIsNotNull() {
      addCriterion("ifjoinExpence is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceEqualTo(Boolean value) {
      addCriterion("ifjoinExpence =", value, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceNotEqualTo(Boolean value) {
      addCriterion("ifjoinExpence <>", value, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceGreaterThan(Boolean value) {
      addCriterion("ifjoinExpence >", value, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceGreaterThanOrEqualTo(Boolean value) {
      addCriterion("ifjoinExpence >=", value, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceLessThan(Boolean value) {
      addCriterion("ifjoinExpence <", value, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceLessThanOrEqualTo(Boolean value) {
      addCriterion("ifjoinExpence <=", value, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceIn(List<Boolean> values) {
      addCriterion("ifjoinExpence in", values, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceNotIn(List<Boolean> values) {
      addCriterion("ifjoinExpence not in", values, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceBetween(Boolean value1, Boolean value2) {
      addCriterion("ifjoinExpence between", value1, value2, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIfjoinexpenceNotBetween(Boolean value1, Boolean value2) {
      addCriterion("ifjoinExpence not between", value1, value2, "ifjoinexpence");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledIsNull() {
      addCriterion("is_enabled is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledIsNotNull() {
      addCriterion("is_enabled is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledEqualTo(Boolean value) {
      addCriterion("is_enabled =", value, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledNotEqualTo(Boolean value) {
      addCriterion("is_enabled <>", value, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledGreaterThan(Boolean value) {
      addCriterion("is_enabled >", value, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_enabled >=", value, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledLessThan(Boolean value) {
      addCriterion("is_enabled <", value, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledLessThanOrEqualTo(Boolean value) {
      addCriterion("is_enabled <=", value, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledIn(List<Boolean> values) {
      addCriterion("is_enabled in", values, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledNotIn(List<Boolean> values) {
      addCriterion("is_enabled not in", values, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledBetween(Boolean value1, Boolean value2) {
      addCriterion("is_enabled between", value1, value2, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsEnabledNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_enabled not between", value1, value2, "isEnabled");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedIsNull() {
      addCriterion("is_locked is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedIsNotNull() {
      addCriterion("is_locked is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedEqualTo(Boolean value) {
      addCriterion("is_locked =", value, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedNotEqualTo(Boolean value) {
      addCriterion("is_locked <>", value, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedGreaterThan(Boolean value) {
      addCriterion("is_locked >", value, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_locked >=", value, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedLessThan(Boolean value) {
      addCriterion("is_locked <", value, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedLessThanOrEqualTo(Boolean value) {
      addCriterion("is_locked <=", value, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedIn(List<Boolean> values) {
      addCriterion("is_locked in", values, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedNotIn(List<Boolean> values) {
      addCriterion("is_locked not in", values, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedBetween(Boolean value1, Boolean value2) {
      addCriterion("is_locked between", value1, value2, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andIsLockedNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_locked not between", value1, value2, "isLocked");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateIsNull() {
      addCriterion("locked_date is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateIsNotNull() {
      addCriterion("locked_date is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateEqualTo(Date value) {
      addCriterion("locked_date =", value, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateNotEqualTo(Date value) {
      addCriterion("locked_date <>", value, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateGreaterThan(Date value) {
      addCriterion("locked_date >", value, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateGreaterThanOrEqualTo(Date value) {
      addCriterion("locked_date >=", value, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateLessThan(Date value) {
      addCriterion("locked_date <", value, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateLessThanOrEqualTo(Date value) {
      addCriterion("locked_date <=", value, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateIn(List<Date> values) {
      addCriterion("locked_date in", values, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateNotIn(List<Date> values) {
      addCriterion("locked_date not in", values, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateBetween(Date value1, Date value2) {
      addCriterion("locked_date between", value1, value2, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLockedDateNotBetween(Date value1, Date value2) {
      addCriterion("locked_date not between", value1, value2, "lockedDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateIsNull() {
      addCriterion("login_date is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateIsNotNull() {
      addCriterion("login_date is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateEqualTo(Date value) {
      addCriterion("login_date =", value, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateNotEqualTo(Date value) {
      addCriterion("login_date <>", value, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateGreaterThan(Date value) {
      addCriterion("login_date >", value, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateGreaterThanOrEqualTo(Date value) {
      addCriterion("login_date >=", value, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateLessThan(Date value) {
      addCriterion("login_date <", value, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateLessThanOrEqualTo(Date value) {
      addCriterion("login_date <=", value, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateIn(List<Date> values) {
      addCriterion("login_date in", values, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateNotIn(List<Date> values) {
      addCriterion("login_date not in", values, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateBetween(Date value1, Date value2) {
      addCriterion("login_date between", value1, value2, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginDateNotBetween(Date value1, Date value2) {
      addCriterion("login_date not between", value1, value2, "loginDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountIsNull() {
      addCriterion("login_failure_count is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountIsNotNull() {
      addCriterion("login_failure_count is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountEqualTo(Integer value) {
      addCriterion("login_failure_count =", value, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountNotEqualTo(Integer value) {
      addCriterion("login_failure_count <>", value, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountGreaterThan(Integer value) {
      addCriterion("login_failure_count >", value, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountGreaterThanOrEqualTo(Integer value) {
      addCriterion("login_failure_count >=", value, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountLessThan(Integer value) {
      addCriterion("login_failure_count <", value, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountLessThanOrEqualTo(Integer value) {
      addCriterion("login_failure_count <=", value, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountIn(List<Integer> values) {
      addCriterion("login_failure_count in", values, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountNotIn(List<Integer> values) {
      addCriterion("login_failure_count not in", values, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountBetween(Integer value1, Integer value2) {
      addCriterion("login_failure_count between", value1, value2, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginFailureCountNotBetween(Integer value1, Integer value2) {
      addCriterion("login_failure_count not between", value1, value2, "loginFailureCount");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpIsNull() {
      addCriterion("login_ip is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpIsNotNull() {
      addCriterion("login_ip is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpEqualTo(String value) {
      addCriterion("login_ip =", value, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpNotEqualTo(String value) {
      addCriterion("login_ip <>", value, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpGreaterThan(String value) {
      addCriterion("login_ip >", value, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpGreaterThanOrEqualTo(String value) {
      addCriterion("login_ip >=", value, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpLessThan(String value) {
      addCriterion("login_ip <", value, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpLessThanOrEqualTo(String value) {
      addCriterion("login_ip <=", value, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpLike(String value) {
      addCriterion("login_ip like", value, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpNotLike(String value) {
      addCriterion("login_ip not like", value, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpIn(List<String> values) {
      addCriterion("login_ip in", values, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpNotIn(List<String> values) {
      addCriterion("login_ip not in", values, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpBetween(String value1, String value2) {
      addCriterion("login_ip between", value1, value2, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andLoginIpNotBetween(String value1, String value2) {
      addCriterion("login_ip not between", value1, value2, "loginIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneIsNull() {
      addCriterion("phone is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneIsNotNull() {
      addCriterion("phone is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneEqualTo(String value) {
      addCriterion("phone =", value, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneNotEqualTo(String value) {
      addCriterion("phone <>", value, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneGreaterThan(String value) {
      addCriterion("phone >", value, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("phone >=", value, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneLessThan(String value) {
      addCriterion("phone <", value, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneLessThanOrEqualTo(String value) {
      addCriterion("phone <=", value, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneLike(String value) {
      addCriterion("phone like", value, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneNotLike(String value) {
      addCriterion("phone not like", value, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneIn(List<String> values) {
      addCriterion("phone in", values, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneNotIn(List<String> values) {
      addCriterion("phone not in", values, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneBetween(String value1, String value2) {
      addCriterion("phone between", value1, value2, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPhoneNotBetween(String value1, String value2) {
      addCriterion("phone not between", value1, value2, "phone");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointIsNull() {
      addCriterion("point is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointIsNotNull() {
      addCriterion("point is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointEqualTo(Long value) {
      addCriterion("point =", value, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointNotEqualTo(Long value) {
      addCriterion("point <>", value, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointGreaterThan(Long value) {
      addCriterion("point >", value, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointGreaterThanOrEqualTo(Long value) {
      addCriterion("point >=", value, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointLessThan(Long value) {
      addCriterion("point <", value, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointLessThanOrEqualTo(Long value) {
      addCriterion("point <=", value, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointIn(List<Long> values) {
      addCriterion("point in", values, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointNotIn(List<Long> values) {
      addCriterion("point not in", values, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointBetween(Long value1, Long value2) {
      addCriterion("point between", value1, value2, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andPointNotBetween(Long value1, Long value2) {
      addCriterion("point not between", value1, value2, "point");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidIsNull() {
      addCriterion("openid is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidIsNotNull() {
      addCriterion("openid is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidEqualTo(String value) {
      addCriterion("openid =", value, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidNotEqualTo(String value) {
      addCriterion("openid <>", value, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidGreaterThan(String value) {
      addCriterion("openid >", value, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidGreaterThanOrEqualTo(String value) {
      addCriterion("openid >=", value, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidLessThan(String value) {
      addCriterion("openid <", value, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidLessThanOrEqualTo(String value) {
      addCriterion("openid <=", value, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidLike(String value) {
      addCriterion("openid like", value, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidNotLike(String value) {
      addCriterion("openid not like", value, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidIn(List<String> values) {
      addCriterion("openid in", values, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidNotIn(List<String> values) {
      addCriterion("openid not in", values, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidBetween(String value1, String value2) {
      addCriterion("openid between", value1, value2, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andOpenidNotBetween(String value1, String value2) {
      addCriterion("openid not between", value1, value2, "openid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidIsNull() {
      addCriterion("weixinopenid is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidIsNotNull() {
      addCriterion("weixinopenid is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidEqualTo(String value) {
      addCriterion("weixinopenid =", value, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidNotEqualTo(String value) {
      addCriterion("weixinopenid <>", value, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidGreaterThan(String value) {
      addCriterion("weixinopenid >", value, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidGreaterThanOrEqualTo(String value) {
      addCriterion("weixinopenid >=", value, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidLessThan(String value) {
      addCriterion("weixinopenid <", value, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidLessThanOrEqualTo(String value) {
      addCriterion("weixinopenid <=", value, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidLike(String value) {
      addCriterion("weixinopenid like", value, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidNotLike(String value) {
      addCriterion("weixinopenid not like", value, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidIn(List<String> values) {
      addCriterion("weixinopenid in", values, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidNotIn(List<String> values) {
      addCriterion("weixinopenid not in", values, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidBetween(String value1, String value2) {
      addCriterion("weixinopenid between", value1, value2, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andWeixinopenidNotBetween(String value1, String value2) {
      addCriterion("weixinopenid not between", value1, value2, "weixinopenid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeIsNull() {
      addCriterion("usertype is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeIsNotNull() {
      addCriterion("usertype is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeEqualTo(Integer value) {
      addCriterion("usertype =", value, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeNotEqualTo(Integer value) {
      addCriterion("usertype <>", value, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeGreaterThan(Integer value) {
      addCriterion("usertype >", value, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("usertype >=", value, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeLessThan(Integer value) {
      addCriterion("usertype <", value, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeLessThanOrEqualTo(Integer value) {
      addCriterion("usertype <=", value, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeIn(List<Integer> values) {
      addCriterion("usertype in", values, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeNotIn(List<Integer> values) {
      addCriterion("usertype not in", values, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeBetween(Integer value1, Integer value2) {
      addCriterion("usertype between", value1, value2, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
      addCriterion("usertype not between", value1, value2, "usertype");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleIsNull() {
      addCriterion("userrole is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleIsNotNull() {
      addCriterion("userrole is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleEqualTo(Integer value) {
      addCriterion("userrole =", value, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleNotEqualTo(Integer value) {
      addCriterion("userrole <>", value, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleGreaterThan(Integer value) {
      addCriterion("userrole >", value, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleGreaterThanOrEqualTo(Integer value) {
      addCriterion("userrole >=", value, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleLessThan(Integer value) {
      addCriterion("userrole <", value, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleLessThanOrEqualTo(Integer value) {
      addCriterion("userrole <=", value, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleIn(List<Integer> values) {
      addCriterion("userrole in", values, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleNotIn(List<Integer> values) {
      addCriterion("userrole not in", values, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleBetween(Integer value1, Integer value2) {
      addCriterion("userrole between", value1, value2, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserroleNotBetween(Integer value1, Integer value2) {
      addCriterion("userrole not between", value1, value2, "userrole");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpIsNull() {
      addCriterion("register_ip is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpIsNotNull() {
      addCriterion("register_ip is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpEqualTo(String value) {
      addCriterion("register_ip =", value, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpNotEqualTo(String value) {
      addCriterion("register_ip <>", value, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpGreaterThan(String value) {
      addCriterion("register_ip >", value, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpGreaterThanOrEqualTo(String value) {
      addCriterion("register_ip >=", value, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpLessThan(String value) {
      addCriterion("register_ip <", value, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpLessThanOrEqualTo(String value) {
      addCriterion("register_ip <=", value, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpLike(String value) {
      addCriterion("register_ip like", value, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpNotLike(String value) {
      addCriterion("register_ip not like", value, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpIn(List<String> values) {
      addCriterion("register_ip in", values, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpNotIn(List<String> values) {
      addCriterion("register_ip not in", values, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpBetween(String value1, String value2) {
      addCriterion("register_ip between", value1, value2, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegisterIpNotBetween(String value1, String value2) {
      addCriterion("register_ip not between", value1, value2, "registerIp");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireIsNull() {
      addCriterion("safe_key_expire is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireIsNotNull() {
      addCriterion("safe_key_expire is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireEqualTo(Date value) {
      addCriterion("safe_key_expire =", value, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireNotEqualTo(Date value) {
      addCriterion("safe_key_expire <>", value, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireGreaterThan(Date value) {
      addCriterion("safe_key_expire >", value, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireGreaterThanOrEqualTo(Date value) {
      addCriterion("safe_key_expire >=", value, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireLessThan(Date value) {
      addCriterion("safe_key_expire <", value, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireLessThanOrEqualTo(Date value) {
      addCriterion("safe_key_expire <=", value, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireIn(List<Date> values) {
      addCriterion("safe_key_expire in", values, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireNotIn(List<Date> values) {
      addCriterion("safe_key_expire not in", values, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireBetween(Date value1, Date value2) {
      addCriterion("safe_key_expire between", value1, value2, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyExpireNotBetween(Date value1, Date value2) {
      addCriterion("safe_key_expire not between", value1, value2, "safeKeyExpire");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueIsNull() {
      addCriterion("safe_key_value is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueIsNotNull() {
      addCriterion("safe_key_value is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueEqualTo(String value) {
      addCriterion("safe_key_value =", value, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueNotEqualTo(String value) {
      addCriterion("safe_key_value <>", value, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueGreaterThan(String value) {
      addCriterion("safe_key_value >", value, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueGreaterThanOrEqualTo(String value) {
      addCriterion("safe_key_value >=", value, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueLessThan(String value) {
      addCriterion("safe_key_value <", value, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueLessThanOrEqualTo(String value) {
      addCriterion("safe_key_value <=", value, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueLike(String value) {
      addCriterion("safe_key_value like", value, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueNotLike(String value) {
      addCriterion("safe_key_value not like", value, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueIn(List<String> values) {
      addCriterion("safe_key_value in", values, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueNotIn(List<String> values) {
      addCriterion("safe_key_value not in", values, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueBetween(String value1, String value2) {
      addCriterion("safe_key_value between", value1, value2, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andSafeKeyValueNotBetween(String value1, String value2) {
      addCriterion("safe_key_value not between", value1, value2, "safeKeyValue");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeIsNull() {
      addCriterion("zip_code is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeIsNotNull() {
      addCriterion("zip_code is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeEqualTo(String value) {
      addCriterion("zip_code =", value, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeNotEqualTo(String value) {
      addCriterion("zip_code <>", value, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeGreaterThan(String value) {
      addCriterion("zip_code >", value, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeGreaterThanOrEqualTo(String value) {
      addCriterion("zip_code >=", value, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeLessThan(String value) {
      addCriterion("zip_code <", value, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeLessThanOrEqualTo(String value) {
      addCriterion("zip_code <=", value, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeLike(String value) {
      addCriterion("zip_code like", value, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeNotLike(String value) {
      addCriterion("zip_code not like", value, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeIn(List<String> values) {
      addCriterion("zip_code in", values, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeNotIn(List<String> values) {
      addCriterion("zip_code not in", values, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeBetween(String value1, String value2) {
      addCriterion("zip_code between", value1, value2, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andZipCodeNotBetween(String value1, String value2) {
      addCriterion("zip_code not between", value1, value2, "zipCode");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaIsNull() {
      addCriterion("area is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaIsNotNull() {
      addCriterion("area is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaEqualTo(Long value) {
      addCriterion("area =", value, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaNotEqualTo(Long value) {
      addCriterion("area <>", value, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaGreaterThan(Long value) {
      addCriterion("area >", value, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaGreaterThanOrEqualTo(Long value) {
      addCriterion("area >=", value, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaLessThan(Long value) {
      addCriterion("area <", value, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaLessThanOrEqualTo(Long value) {
      addCriterion("area <=", value, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaIn(List<Long> values) {
      addCriterion("area in", values, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaNotIn(List<Long> values) {
      addCriterion("area not in", values, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaBetween(Long value1, Long value2) {
      addCriterion("area between", value1, value2, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAreaNotBetween(Long value1, Long value2) {
      addCriterion("area not between", value1, value2, "area");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankIsNull() {
      addCriterion("member_rank is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankIsNotNull() {
      addCriterion("member_rank is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankEqualTo(Long value) {
      addCriterion("member_rank =", value, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankNotEqualTo(Long value) {
      addCriterion("member_rank <>", value, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankGreaterThan(Long value) {
      addCriterion("member_rank >", value, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankGreaterThanOrEqualTo(Long value) {
      addCriterion("member_rank >=", value, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankLessThan(Long value) {
      addCriterion("member_rank <", value, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankLessThanOrEqualTo(Long value) {
      addCriterion("member_rank <=", value, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankIn(List<Long> values) {
      addCriterion("member_rank in", values, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankNotIn(List<Long> values) {
      addCriterion("member_rank not in", values, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankBetween(Long value1, Long value2) {
      addCriterion("member_rank between", value1, value2, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andMemberRankNotBetween(Long value1, Long value2) {
      addCriterion("member_rank not between", value1, value2, "memberRank");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidIsNull() {
      addCriterion("agentid is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidIsNotNull() {
      addCriterion("agentid is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidEqualTo(Long value) {
      addCriterion("agentid =", value, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidNotEqualTo(Long value) {
      addCriterion("agentid <>", value, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidGreaterThan(Long value) {
      addCriterion("agentid >", value, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidGreaterThanOrEqualTo(Long value) {
      addCriterion("agentid >=", value, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidLessThan(Long value) {
      addCriterion("agentid <", value, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidLessThanOrEqualTo(Long value) {
      addCriterion("agentid <=", value, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidIn(List<Long> values) {
      addCriterion("agentid in", values, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidNotIn(List<Long> values) {
      addCriterion("agentid not in", values, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidBetween(Long value1, Long value2) {
      addCriterion("agentid between", value1, value2, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andAgentidNotBetween(Long value1, Long value2) {
      addCriterion("agentid not between", value1, value2, "agentid");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceIsNull() {
      addCriterion("regSource is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceIsNotNull() {
      addCriterion("regSource is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceEqualTo(Short value) {
      addCriterion("regSource =", value, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceNotEqualTo(Short value) {
      addCriterion("regSource <>", value, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceGreaterThan(Short value) {
      addCriterion("regSource >", value, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceGreaterThanOrEqualTo(Short value) {
      addCriterion("regSource >=", value, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceLessThan(Short value) {
      addCriterion("regSource <", value, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceLessThanOrEqualTo(Short value) {
      addCriterion("regSource <=", value, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceIn(List<Short> values) {
      addCriterion("regSource in", values, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceNotIn(List<Short> values) {
      addCriterion("regSource not in", values, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceBetween(Short value1, Short value2) {
      addCriterion("regSource between", value1, value2, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andRegsourceNotBetween(Short value1, Short value2) {
      addCriterion("regSource not between", value1, value2, "regsource");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusIsNull() {
      addCriterion("userstatus is null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusIsNotNull() {
      addCriterion("userstatus is not null");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusEqualTo(Short value) {
      addCriterion("userstatus =", value, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusNotEqualTo(Short value) {
      addCriterion("userstatus <>", value, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusGreaterThan(Short value) {
      addCriterion("userstatus >", value, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusGreaterThanOrEqualTo(Short value) {
      addCriterion("userstatus >=", value, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusLessThan(Short value) {
      addCriterion("userstatus <", value, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusLessThanOrEqualTo(Short value) {
      addCriterion("userstatus <=", value, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusIn(List<Short> values) {
      addCriterion("userstatus in", values, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusNotIn(List<Short> values) {
      addCriterion("userstatus not in", values, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusBetween(Short value1, Short value2) {
      addCriterion("userstatus between", value1, value2, "userstatus");
      return ((MemberExample.Criteria)this);
    }

    public MemberExample.Criteria andUserstatusNotBetween(Short value1, Short value2) {
      addCriterion("userstatus not between", value1, value2, "userstatus");
      return ((MemberExample.Criteria)this);
    }
  }
}
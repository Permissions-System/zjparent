package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.dao.MemberAccountMapper;
import com.zjgt.p2p.dao.MemberAcctAttriMapper;
import com.zjgt.p2p.dao.MemberAcctMapper;
import com.zjgt.p2p.dao.MemberActPwdMapper;
import com.zjgt.p2p.dao.MemberMapper;
import com.zjgt.p2p.dao.MemberbankinfoMapper;
import com.zjgt.p2p.dao.MembersafetyMapper;
import com.zjgt.p2p.exception.MemberException;
import com.zjgt.p2p.model.Agent;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAccountExample;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.MemberAcctAttri;
import com.zjgt.p2p.model.MemberAcctExample;
import com.zjgt.p2p.model.MemberActPwd;
import com.zjgt.p2p.model.MemberActPwdExample;
import com.zjgt.p2p.model.MemberExample;
import com.zjgt.p2p.model.MemberExcleExample;
import com.zjgt.p2p.model.MemberQuery;
import com.zjgt.p2p.model.Memberbankinfo;
import com.zjgt.p2p.model.Membersafety;
import com.zjgt.p2p.model.MembersafetyExample;
import com.zjgt.p2p.service.AgentService;
import com.zjgt.p2p.service.BonusService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.p2p.util.email.EmailBean;
import com.zjgt.p2p.util.email.SendEmail;
import com.zjgt.util.PropertiesUtils;
import com.zjgt.util.SafeUtil;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("memberservice")
public class MemberServiceImpl
  implements MemberService
{
  Logger logger;

  @Autowired
  private MemberMapper dao;

  @Autowired
  private MemberActPwdMapper pwddao;

  @Autowired
  private MembersafetyMapper safedao;

  @Autowired
  private MemberAccountMapper mamapper;

  @Autowired
  private MemberAcctMapper memberacctmapper;

  @Autowired
  private MemberAcctAttriMapper memberacctattrimapper;

  @Autowired
  private MemberbankinfoMapper memberbankinfomapper;

  @Autowired
  private MemberAcctMapper memberacmapper;

  @Autowired
  private BonusService bonusService;

  @Autowired
  private MessageService messageService;

  @Autowired
  private AgentService agentService;

  public MemberServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(MemberServiceImpl.class);
  }

  @Transactional
  public Member register(Member member, String emailverifyuuid)
    throws MemberException
  {
    if (member.getAgentid() != null) {
      Member agent = this.dao.selectByPrimaryKey(member.getAgentid());
      if (agent == null) {
        member.setAgentid(null);
      }
    }
    member.setPassword(SafeUtil.generatePassword(member.getPassword()));
    member.setIsEnabled(Boolean.valueOf(true));
    member.setIsLocked(Boolean.valueOf(false));
    member.setCreateDate(new Date());
    member.setModifyDate(new Date());
    member.setLoginFailureCount(Integer.valueOf(0));
    member.setPoint(Long.valueOf(0L));
    member.setLoginDate(new Date());
    member.setMemberRank(Long.valueOf(0L));
    member.setAmount(new BigDecimal(0));
    member.setIfjoinexpence(Boolean.valueOf(false));
    if ((findByEmail(member.getEmail())) && (getMobileForMember(member.getMobile()) == 0)) {
      this.dao.insertSelective(member);
      Membersafety membersafety = new Membersafety();
      if (member.getEmail() != null) {
        member.setId(findIdByEmail(member.getEmail()));
        membersafety.setMobileifverified(Integer.valueOf(0));

        membersafety.setEmailverifyuuid(emailverifyuuid);
        membersafety.setEmailverifydate(new Date());
      }
      if (member.getMobile() != null) {
        member.setId(Long.valueOf(findIdByMobile(member.getMobile())));
        membersafety.setMobile(member.getMobile());
        membersafety.setMobileifverified(Integer.valueOf(1));
        membersafety.setMobileifverifydate(new Date());
      }

      membersafety.setMemberid(member.getId());
      membersafety.setEmailifverified(Integer.valueOf(0));
      membersafety.setBankcardifverified(Integer.valueOf(0));
      membersafety.setIdcardifverified(Integer.valueOf(0));
      membersafety.setTranspasswdverified(Integer.valueOf(0));
      membersafety.setEmail(member.getEmail());
      this.safedao.insertSelective(membersafety);

      MemberAccount memberaccount = new MemberAccount();
      memberaccount.setMemberid(member.getId());
      memberaccount.setModifyDate(new Date());
      memberaccount.setCreateDate(new Date());
      memberaccount.setUpdateDate(new Date());
      this.mamapper.insertSelective(memberaccount);

      MemberAcct memberacct = new MemberAcct();
      memberacct.setMemberid(member.getId());
      memberacct.setCreateDate(new Date());
      memberacct.setAcctType(Integer.valueOf(AcctType.BASIC.getKey()));
      memberacct.setAcctName(AcctType.BASIC.getValue());
      memberacct.setBlance(new BigDecimal(0));
      memberacct.setFreezeBlance(new BigDecimal(0));
      memberacct.setModifyDate(new Date());
      memberacct.setUpdateDate(new Date());
      this.memberacctmapper.insertSelective(memberacct);

      this.bonusService.addRegBonus(member.getId());

      MemberAcctAttri memberacctattri = new MemberAcctAttri();
      memberacctattri.setCreateDate(new Date());
      memberacctattri.setMemberid(member.getId());
      memberacctattri.setWithdrawStatus(Integer.valueOf(1));
      memberacctattri.setOperDate(new Date());
      memberacctattri.setOperUser("System");
      memberacctattri.setUpdateDate(new Date());
      this.memberacctattrimapper.insertSelective(memberacctattri);

      this.messageService.sendMessage("message.register", member.getId().longValue(), new String[0]);
    }
    return member;
  }

  public MemberAccount getMemberAccountbyMemberId(long id)
  {
    MemberAccountExample exam = new MemberAccountExample();
    exam.createCriteria().andMemberidEqualTo(Long.valueOf(id));
    return ((MemberAccount)this.mamapper.selectByExample(exam).get(0));
  }

  public Member login(String email, String password)
  {
    List memberlist = null;
    MemberExample exam = new MemberExample();
    MemberExample.Criteria crite = exam.createCriteria().andEmailEqualTo(email);
    crite.andPasswordEqualTo(SafeUtil.generatePassword(password));
    exam.or(crite);
    memberlist = this.dao.selectByExample(exam);
    if (memberlist.size() == 0) {
      throw new MemberException("用户名或密码错误!!!");
    }
    Member member = new Member();
    member.setId(((Member)memberlist.get(0)).getId());
    member.setLoginDate(new Date());
    this.dao.updateByPrimaryKeySelective(member);
    return ((Member)memberlist.get(0));
  }

  public void updateLastLoginDateByPrimary(Long primaryKey) {
    Member member = new Member();
    member.setId(primaryKey);
    member.setLoginDate(new Date());
    this.dao.updateByPrimaryKeySelective(member);
  }

  public boolean findByName(String name)
  {
    MemberExample exam = new MemberExample();
    MemberExample.Criteria crite = exam.createCriteria().andUsernameEqualTo(name);
    exam.or(crite);
    List members = this.dao.selectByExample(exam);

    return (members.size() != 0);
  }

  public boolean findByEmail(String email)
  {
    if (email == null) {
      return true;
    }
    MemberExample exam = new MemberExample();
    exam.createCriteria().andEmailEqualTo(email);
    List members = this.dao.selectByExample(exam);

    return (members.size() == 0);
  }

  public void modifyNickname(Member member)
  {
    this.dao.updateByPrimaryKeySelective(member);
  }

  public int modifyemail(Member member) throws MemberException
  {
    int status = 0;
    try {
      status = this.dao.updateByPrimaryKeySelective(member);
    } catch (Exception e) {
      throw new MemberException("member exception");
    }
    return status;
  }

  public Member findByOpenId(String openid) throws MemberException
  {
    MemberExample exam = new MemberExample();
    List memberlist = null;
    MemberExample.Criteria criteria = exam.createCriteria().andOpenidEqualTo(openid);
    exam.or(criteria);
    memberlist = this.dao.selectByExample(exam);
    if (memberlist.size() == 0) {
      return null;
    }
    return ((Member)memberlist.get(0));
  }

  public void registerQQ(Member member)
  {
    member.setNickname(UUID.randomUUID().toString().split("-")[0]);
    member.setPassword(SafeUtil.generatePassword("111111"));
    member.setIsEnabled(Boolean.valueOf(true));
    member.setIsLocked(Boolean.valueOf(false));
    member.setCreateDate(new Date());
    member.setModifyDate(new Date());
    member.setLoginFailureCount(Integer.valueOf(0));
    member.setPoint(Long.valueOf(0L));
    member.setLoginDate(new Date());
    member.setMemberRank(Long.valueOf(0L));
    member.setAmount(new BigDecimal(0));
    this.dao.insertSelective(member);
    Membersafety membersafety = new Membersafety();
    membersafety.setMemberid(findByOpenId(member.getOpenid()).getId());
    membersafety.setEmailifverified(Integer.valueOf(0));
    membersafety.setBankcardifverified(Integer.valueOf(0));
    membersafety.setIdcardifverified(Integer.valueOf(0));
    membersafety.setMobileifverified(Integer.valueOf(0));
    membersafety.setTranspasswdverified(Integer.valueOf(0));
    this.safedao.insert(membersafety);

    MemberAccount memberaccount = new MemberAccount();
    memberaccount.setMemberid(findByOpenId(member.getOpenid()).getId());
    memberaccount.setModifyDate(new Date());
    memberaccount.setCreateDate(new Date());
    memberaccount.setUpdateDate(new Date());
    this.mamapper.insertSelective(memberaccount);

    MemberAcct memberacct = new MemberAcct();
    memberacct.setMemberid(findByOpenId(member.getOpenid()).getId());
    memberacct.setCreateDate(new Date());
    memberacct.setAcctType(Integer.valueOf(10));
    memberacct.setAcctName("普通会员");
    memberacct.setBlance(new BigDecimal(0));
    memberacct.setFreezeBlance(new BigDecimal(0));
    memberacct.setModifyDate(new Date());
    memberacct.setUpdateDate(new Date());
    this.memberacctmapper.insertSelective(memberacct);

    MemberAcctAttri memberacctattri = new MemberAcctAttri();
    memberacctattri.setCreateDate(new Date());
    memberacctattri.setMemberid(findByOpenId(member.getOpenid()).getId());
    memberacctattri.setWithdrawStatus(Integer.valueOf(1));
    memberacctattri.setOperDate(new Date());
    memberacctattri.setOperUser("System");
    memberacctattri.setUpdateDate(new Date());
    this.memberacctattrimapper.insertSelective(memberacctattri);
  }

  public Long findIdByEmail(String email)
  {
    MemberExample exam = new MemberExample();
    MemberExample.Criteria crite = exam.createCriteria().andEmailEqualTo(email);
    exam.or(crite);
    List members = this.dao.selectByExample(exam);
    return ((Member)members.get(0)).getId();
  }

  public long findIdByMobile(String mobile)
  {
    MemberExample exam = new MemberExample();
    MemberExample.Criteria crite = exam.createCriteria().andMobileEqualTo(mobile);
    exam.or(crite);
    List members = this.dao.selectByExample(exam);
    return ((Member)members.get(0)).getId().longValue();
  }

  public boolean findUUIDIsValid(String uuid)
  {
    MemberActPwdExample me = new MemberActPwdExample();
    MemberActPwdExample.Criteria crt = me.createCriteria().andPwduuidEqualTo(uuid);
    me.or(crt);
    List mbwps = this.pwddao.selectByExample(me);
    if (mbwps.get(0) == null) {
      return false;
    }
    return ((MemberActPwd)mbwps.get(0)).getUuidisvalid().booleanValue();
  }

  public void updataPassword(Member member, String uuid)
  {
    long id = findIdByEmail(member.getEmail()).longValue();
    MemberActPwd mpwd = new MemberActPwd();
    mpwd.setPwduuid(uuid);
    mpwd.setMemberid(Integer.valueOf((int)id));
    mpwd.setUuidisvalid(Boolean.valueOf(true));
    this.pwddao.insertSelective(mpwd);
  }

  public void modifyPassword(MemberActPwd mbpw, Member member)
  {
    MemberActPwdExample me = new MemberActPwdExample();
    MemberActPwdExample.Criteria crt = me.createCriteria().andPwduuidEqualTo(mbpw.getPwduuid());
    me.or(crt);
    List mbwps = this.pwddao.selectByExample(me);
    mbpw.setId(((MemberActPwd)mbwps.get(0)).getId());
    member.setPassword(SafeUtil.generatePassword(member.getPassword()));
    member.setId(Long.valueOf(((MemberActPwd)mbwps.get(0)).getMemberid().intValue()));
    this.dao.updateByPrimaryKeySelective(member);
    this.pwddao.updateByPrimaryKeySelective(mbpw);
  }

  public boolean isRightPwd(Member member, String pwd)
  {
    return (member.getPassword().equals(SafeUtil.generatePassword(pwd)));
  }

  public Member findMemberByEmail(String email)
  {
    MemberExample exam = new MemberExample();
    exam.createCriteria().andEmailEqualTo(email);
    List members = this.dao.selectByExample(exam);
    if (!(members.isEmpty())) {
      return ((Member)members.get(0));
    }
    return null;
  }

  public void updateMembersafety(Membersafety ms)
  {
    MembersafetyExample exam = new MembersafetyExample();
    MembersafetyExample.Criteria crt = exam.createCriteria().andMemberidEqualTo(ms.getMemberid());
    exam.or(crt);
    Membersafety membersafety = (Membersafety)this.safedao.selectByExample(exam).get(0);
    membersafety.setEmailverifyuuid(ms.getEmailverifyuuid());
    membersafety.setEmailverifydate(ms.getEmailverifydate());
    this.safedao.updateByPrimaryKeySelective(membersafety);
  }

  public Membersafety authenticationEmail(String email, String emailverifyuuid)
  {
    MembersafetyExample exam = new MembersafetyExample();
    exam.createCriteria().andEmailEqualTo(email).andEmailverifyuuidEqualTo(emailverifyuuid);
    List membersafetys = this.safedao.selectByExample(exam);
    if ((membersafetys == null) || (membersafetys.isEmpty())) {
      return null;
    }
    Membersafety membersafety = (Membersafety)membersafetys.get(0);
    if (membersafety.getEmailifverified().intValue() == 1) {
      return null;
    }

    if (new Date().getTime() - membersafety.getEmailverifydate().getTime() > 86400000L) {
      return null;
    }
    membersafety.setEmailifverified(Integer.valueOf(1));
    this.safedao.updateByPrimaryKeySelective(membersafety);
    return membersafety;
  }

  public Membersafety authenticationIDcard(long id, String idcard, String realname)
  {
    MembersafetyExample exam = new MembersafetyExample();
    MembersafetyExample.Criteria crt = exam.createCriteria().andMemberidEqualTo(Long.valueOf(id));
    exam.or(crt);
    List membersafetys = this.safedao.selectByExample(exam);
    Membersafety ms = (Membersafety)membersafetys.get(0);

    ms.setIdcard(idcard);
    ms.setRealname(realname);
    ms.setIdcardifverified(Integer.valueOf(1));
    ms.setIdcardverifydate(new Date());
    this.safedao.updateByPrimaryKeySelective(ms);
    Member member = new Member();
    member.setId(Long.valueOf(id));
    member.setRealname(realname);
    member.setIdcard(idcard);
    this.dao.updateByPrimaryKeySelective(member);

    return ms;
  }

  public void authenticationMobil(long memberid, long id, String mobile)
  {
    Member member = new Member();
    member.setId(Long.valueOf(memberid));
    member.setMobile(mobile);
    this.dao.updateByPrimaryKeySelective(member);
    Membersafety ms = new Membersafety();
    ms.setId(Long.valueOf(id));
    ms.setMobile(mobile);
    ms.setMobileifverified(Integer.valueOf(1));
    ms.setMobileifverifydate(new Date());
    this.safedao.updateByPrimaryKeySelective(ms);
  }

  public Membersafety authenticationBankcard(Membersafety ms)
  {
    MembersafetyExample exam = new MembersafetyExample();
    MembersafetyExample.Criteria crt = exam.createCriteria().andMemberidEqualTo(ms.getMemberid());
    exam.or(crt);
    List membersafetys = this.safedao.selectByExample(exam);
    Membersafety dbms = (Membersafety)membersafetys.get(0);

    if (dbms.getBankcardifverified().intValue() == 0) {
      Agent agent = this.agentService.selectByInvitee(ms.getMemberid());

      if ((agent != null) && (agent.getIsMerchant().intValue() == 1))
      {
        this.agentService.merchantActivity(ms.getMemberid());
      }
    }
    dbms.setBankcardno(ms.getBankcardno());
    dbms.setBankcardifverified(Integer.valueOf(1));
    if (ms.getBankcity() != null) {
      dbms.setBankcity(ms.getBankcity());
    }
    if (ms.getBankname() != null) {
      dbms.setBankname(ms.getBankname());
    }
    if (ms.getBankprince() != null) {
      dbms.setBankprince(ms.getBankprince());
    }
    if (ms.getBankinfo() != null) {
      dbms.setBankinfo(ms.getBankinfo());
    }
    dbms.setBankcode(ms.getBankcode());
    this.safedao.updateByPrimaryKeySelective(dbms);
    Member member = new Member();
    member.setId(ms.getMemberid());
    member.setBankcardno(ms.getBankcardno());
    this.dao.updateByPrimaryKeySelective(member);

    Memberbankinfo memberbankinfo = new Memberbankinfo();
    memberbankinfo.setMemberid(member.getId());
    memberbankinfo.setBankname(dbms.getBankname());
    memberbankinfo.setBankcity(dbms.getBankcity());
    memberbankinfo.setBankcardno(dbms.getBankcardno());
    memberbankinfo.setBankprince(dbms.getBankprince());
    memberbankinfo.setBankverifydate(new Date());
    memberbankinfo.setIfdefault(Boolean.valueOf(true));
    memberbankinfo.setBankinfo(dbms.getBankinfo());
    this.memberbankinfomapper.insertSelective(memberbankinfo);
    return dbms;
  }

  public int updataMember(Member member)
  {
    return this.dao.updateByPrimaryKeySelective(member);
  }

  public Membersafety findMembersafety(long id)
  {
    MembersafetyExample exam = new MembersafetyExample();
    MembersafetyExample.Criteria crt = exam.createCriteria().andMemberidEqualTo(Long.valueOf(id));
    exam.or(crt);
    List membersafetys = this.safedao.selectByExample(exam);
    return ((Membersafety)membersafetys.get(0));
  }

  public void alterPassword(long id, String newpassword)
  {
    Member member = new Member();
    member.setId(Long.valueOf(id));
    member.setPassword(newpassword);
    this.dao.updateByPrimaryKeySelective(member);
  }

  public void adddealpassword(long memberid, long id, String password)
  {
    Membersafety membersafety = new Membersafety();
    Member member = new Member();
    membersafety.setId(Long.valueOf(id));
    membersafety.setTranspasswd(SafeUtil.generatePassword(password));
    membersafety.setTranspasswdverified(Integer.valueOf(1));
    member.setId(Long.valueOf(memberid));

    member.setTranspasswd(SafeUtil.generatePassword(password));
    this.dao.updateByPrimaryKeySelective(member);
    this.safedao.updateByPrimaryKeySelective(membersafety);
  }

  public int modifyAmount(String id, String amount)
  {
    Member record = new Member();
    if (id != null) {
      record.setId(Long.valueOf(Long.parseLong(id)));
    }
    if (amount != null) {
      record.setAmount(new BigDecimal(amount));
    }
    return this.dao.updateByPrimaryKeySelective(record);
  }

  public Member findMemberByPrimaryKey(Long primaryKey)
  {
    MemberExample exam = new MemberExample();
    exam.createCriteria().andIdEqualTo(primaryKey);
    List members = this.dao.selectByExample(exam);
    if (!(members.isEmpty())) {
      return ((Member)members.get(0));
    }
    return null;
  }

  public Page<Member> findListByPage(MemberQuery memberQuery, int pageNo, int pageSize)
    throws BusinessException
  {
    MemberExample exam = new MemberExample();
    MemberExample.Criteria crite = exam.createCriteria();
    if (org.apache.commons.lang3.StringUtils.isNotEmpty(memberQuery.getEmail())) {
      crite.andEmailOrMobileLike(String.valueOf("%" + memberQuery.getEmail() + "%"));
    }
    if (org.apache.commons.lang3.StringUtils.isNotEmpty(memberQuery.getUsername())) {
      crite.andUsernameLike(String.valueOf("%" + memberQuery.getUsername() + "%"));
    }
    if (org.apache.commons.lang3.StringUtils.isNotEmpty(memberQuery.getRealname()))
      crite.andRealnameLike(String.valueOf("%" + memberQuery.getRealname() + "%"));
    try
    {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date start;
      if ((memberQuery.getCreateDateStart() != null) && (memberQuery.getCreateDateEnd() != null)) {
        start = format.parse(DateUtils.getDateStr(memberQuery.getCreateDateStart()) + " 00:00:00");
        Date end = format.parse(DateUtils.getDateStr(memberQuery.getCreateDateEnd()) + " 23:59:59");
        crite.andCreateDateBetween(start, end);
      } else if (memberQuery.getCreateDateStart() != null) {
        start = format.parse(DateUtils.getDateStr(memberQuery.getCreateDateStart()) + " 00:00:00");
        crite.andCreateDateGreaterThanOrEqualTo(start);
      } else if (memberQuery.getCreateDateEnd() != null) {
        Date end = format.parse(DateUtils.getDateStr(memberQuery.getCreateDateEnd()) + " 23:59:59");
        crite.andCreateDateLessThanOrEqualTo(end);
      }
    } catch (Exception exception) {
      throw new BusinessException("解析日期出错 ", exception);
    }
    if (memberQuery.getUserstatus() != null) {
      crite.andUserstatusEqualTo(memberQuery.getUserstatus());
    }
    if (memberQuery.getAgentid() != null) {
      crite.andAgentidEqualTo(memberQuery.getAgentid());
    }
    if (org.springfk.pancloud.utils.StringUtils.isNotEmpty(memberQuery.getUserSource())) {
      crite.andRegsourceEqualTo(Short.valueOf(memberQuery.getUserSource()));
    }
    exam.setOrderByClause("create_date desc");

    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    exam.setPage(page);
    page.setResult(this.dao.selectByExample(exam));
    return page;
  }

  public Membersafety findMemberSafetyByMemberId(Long memberId)
  {
    MembersafetyExample example = new MembersafetyExample();
    example.createCriteria().andMemberidEqualTo(memberId);
    List list = this.safedao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Membersafety)list.get(0));
    }
    return null;
  }

  public void updateformthree(Member member, String emailverifyuuid)
  {
    this.dao.updateByPrimaryKeySelective(member);
    Membersafety ms = findMembersafety(member.getId().longValue());
    ms.setEmail(member.getEmail());
    ms.setEmailverifyuuid(emailverifyuuid);
    ms.setEmailverifydate(new Date());
    this.safedao.updateByPrimaryKeySelective(ms);
  }

  public Member findMemberByid(long id)
  {
    return this.dao.selectByPrimaryKey(Long.valueOf(id));
  }

  public List<Member> selectPlatformMember(BigDecimal amount)
  {
    MemberAcctExample exam = new MemberAcctExample();
    exam.createCriteria().andAcctTypeEqualTo(Integer.valueOf(AcctType.BASIC.getKey())).andMembertypeEqualTo(Integer.valueOf(2)).andBlanceGreaterThanOrEqualTo(amount);
    List<MemberAcct> listacct = this.memberacctmapper.selectByExample(exam);
    List list = new ArrayList();
    if ((listacct != null) && (!(listacct.isEmpty()))) {
      for (MemberAcct acct : listacct) {
        MemberExample example = new MemberExample();
        example.createCriteria().andIfselfmemberEqualTo(Boolean.TRUE).andIdEqualTo(acct.getMemberid());
        List listmember = this.dao.selectByExample(example);
        if ((listmember != null) && (!(listmember.isEmpty()))) {
          list.add(listmember.get(0));
        }
      }
    }
    return list;
  }

  public List<Member> selectPlatformMember()
  {
    MemberExample exam = new MemberExample();
    exam.createCriteria().andIfselfmemberEqualTo(Boolean.valueOf(true)).andIsEnabledEqualTo(Boolean.valueOf(true));
    List list = new ArrayList();
    list = this.dao.selectByExample(exam);
    return list;
  }

  public int updateByPrimaryKey(Member record)
  {
    return this.dao.updateByPrimaryKeySelective(record);
  }

  public int getMobile(String mobile) {
    MembersafetyExample exam = new MembersafetyExample();
    exam.createCriteria().andMobileEqualTo(mobile).andMobileifverifiedEqualTo(Integer.valueOf(1));
    return this.safedao.selectByExample(exam).size();
  }

  public int getMobileForMember(String mobile) {
    if (mobile == null) {
      return 0;
    }
    MemberExample exam = new MemberExample();
    exam.createCriteria().andMobileEqualTo(mobile);
    return this.dao.selectByExample(exam).size();
  }

  public Page<Map<String, Object>> getReferralByPage(Map<String, Object> paramMap)
  {
    int pageNow = 0;
    if (paramMap.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)paramMap.get("pageNow")).intValue();
    }
    Page page = new Page(pageNow, Integer.parseInt((String)paramMap.get("pageSize")));
    paramMap.put("pageObject", page);
    page.setResult(this.dao.getReferralByPage(paramMap));
    return page;
  }

  public Member findMemberByAll(String username)
  {
    MemberExample exam = new MemberExample();
    exam.createCriteria().andEmailEqualTo(username);
    exam.or(exam.createCriteria().andMobileEqualTo(username));
    List members = this.dao.selectByExample(exam);
    if (!(members.isEmpty())) {
      return ((Member)members.get(0));
    }
    return null;
  }

  public Map<String, Object> getSumAccount(Long memberid)
  {
    if (memberid == null) {
      return null;
    }
    return this.dao.getSumAccount(memberid);
  }

  @Transactional
  public int updateNewPwd(Long memberId)
  {
    Member member = findMemberByid(memberId.longValue());
    String uuid = UUID.randomUUID().toString();
    String newPwd = uuid.substring(0, 8);
    member.setPassword(SafeUtil.generatePassword(newPwd));
    int result = updataMember(member);
    try {
      String sendContext = PropertiesUtils.getProperties("email.context.updatePwNotice");
      sendContext = MessageFormat.format(sendContext, new Object[] { newPwd, DateUtils.getCurrentFormatDate("yyyy-MM-dd") });
      member.setPassword(newPwd);
      SendEmail.sendHtmlEmail(EmailBean.getbean(member.getEmail(), sendContext));
    } catch (Exception e) {
      this.logger.error("重置新密码,发送邮件失败", e);
      throw new RuntimeException("接受邮箱不可用,重置密码失败!");
    }
    return result;
  }

  @Transactional
  public void modifyPasswordByMobile(String mobile, String password) {
    MemberExample exam = new MemberExample();
    Member member = new Member();
    exam.createCriteria().andMobileEqualTo(mobile);
    List members = this.dao.selectByExample(exam);
    if (members.size() != 0) {
      member.setId(((Member)members.get(0)).getId());
      member.setMobile(mobile);
      member.setPassword(password);
      this.dao.updateByPrimaryKeySelective(member);
    }
  }

  public List<Map<String, Object>> findMembersForExcle(MemberQuery memberQuery)
    throws BusinessException
  {
    MemberExcleExample exam = new MemberExcleExample();
    MemberExcleExample.Criteria crite = exam.createCriteria();
    crite.andIdIsNotNull();
    if (org.apache.commons.lang3.StringUtils.isNotEmpty(memberQuery.getEmail())) {
      crite.andEmailOrMobileLike(String.valueOf("%" + memberQuery.getEmail() + "%"));
    }
    if (org.apache.commons.lang3.StringUtils.isNotEmpty(memberQuery.getUsername())) {
      crite.andUsernameLike(String.valueOf("%" + memberQuery.getUsername() + "%"));
    }
    if (org.apache.commons.lang3.StringUtils.isNotEmpty(memberQuery.getRealname()))
      crite.andRealnameLike(String.valueOf("%" + memberQuery.getRealname() + "%"));
    try
    {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date start;
      if ((memberQuery.getCreateDateStart() != null) && (memberQuery.getCreateDateEnd() != null)) {
        start = format.parse(DateUtils.getDateStr(memberQuery.getCreateDateStart()) + " 00:00:00");
        Date end = format.parse(DateUtils.getDateStr(memberQuery.getCreateDateEnd()) + " 23:59:59");
        crite.andCreateDateBetween(start, end);
      } else if (memberQuery.getCreateDateStart() != null) {
        start = format.parse(DateUtils.getDateStr(memberQuery.getCreateDateStart()) + " 00:00:00");
        crite.andCreateDateGreaterThanOrEqualTo(start);
      } else if (memberQuery.getCreateDateEnd() != null) {
        Date end = format.parse(DateUtils.getDateStr(memberQuery.getCreateDateEnd()) + " 23:59:59");
        crite.andCreateDateLessThanOrEqualTo(end);
      }
    } catch (Exception exception) {
      throw new BusinessException("解析日期出错 ", exception);
    }
    if (memberQuery.getUserstatus() != null) {
      crite.andUserstatusEqualTo(memberQuery.getUserstatus());
    }
    if (memberQuery.getAgentid() != null) {
      crite.andAgentidEqualTo(memberQuery.getAgentid());
    }
    if (org.springfk.pancloud.utils.StringUtils.isNotEmpty(memberQuery.getUserSource())) {
      crite.andRegSourceEqualTo(Long.valueOf(memberQuery.getUserSource()));
    }
    exam.setOrderByClause("m.create_date desc");
    return this.dao.findMembersForExcle(exam);
  }
}
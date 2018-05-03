package com.zjgt.p2p.service;

import com.zjgt.p2p.exception.MemberException;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberActPwd;
import com.zjgt.p2p.model.MemberQuery;
import com.zjgt.p2p.model.Membersafety;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface MemberService
{
  public abstract Member register(Member paramMember, String paramString)
    throws MemberException;

  public abstract Member login(String paramString1, String paramString2);

  public abstract boolean findByEmail(String paramString);

  public abstract boolean findByName(String paramString);

  public abstract void modifyNickname(Member paramMember)
    throws MemberException;

  public abstract int modifyemail(Member paramMember)
    throws MemberException;

  public abstract Member findByOpenId(String paramString)
    throws MemberException;

  public abstract void registerQQ(Member paramMember)
    throws MemberException;

  public abstract Long findIdByEmail(String paramString);

  public abstract boolean findUUIDIsValid(String paramString);

  public abstract void updataPassword(Member paramMember, String paramString);

  public abstract void modifyPassword(MemberActPwd paramMemberActPwd, Member paramMember);

  public abstract boolean isRightPwd(Member paramMember, String paramString);

  public abstract Member findMemberByEmail(String paramString);

  public abstract Member findMemberByPrimaryKey(Long paramLong);

  public abstract Membersafety findMemberSafetyByMemberId(Long paramLong);

  public abstract void updateLastLoginDateByPrimary(Long paramLong);

  public abstract MemberAccount getMemberAccountbyMemberId(long paramLong);

  public abstract int modifyAmount(String paramString1, String paramString2);

  public abstract Membersafety authenticationEmail(String paramString1, String paramString2);

  public abstract Membersafety authenticationIDcard(long paramLong, String paramString1, String paramString2);

  public abstract Membersafety authenticationBankcard(Membersafety paramMembersafety);

  public abstract void authenticationMobil(long paramLong1, long paramLong2, String paramString);

  public abstract int updataMember(Member paramMember);

  public abstract Membersafety findMembersafety(long paramLong);

  public abstract void alterPassword(long paramLong, String paramString);

  public abstract void adddealpassword(long paramLong1, long paramLong2, String paramString);

  public abstract void updateformthree(Member paramMember, String paramString);

  public abstract Page<Member> findListByPage(MemberQuery paramMemberQuery, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract void updateMembersafety(Membersafety paramMembersafety);

  public abstract Member findMemberByid(long paramLong);

  public abstract List<Member> selectPlatformMember(BigDecimal paramBigDecimal);

  public abstract List<Member> selectPlatformMember();

  public abstract int updateByPrimaryKey(Member paramMember);

  public abstract int getMobile(String paramString);

  public abstract Page<Map<String, Object>> getReferralByPage(Map<String, Object> paramMap);

  public abstract Member findMemberByAll(String paramString);

  public abstract int getMobileForMember(String paramString);

  public abstract long findIdByMobile(String paramString);

  public abstract Map<String, Object> getSumAccount(Long paramLong);

  public abstract int updateNewPwd(Long paramLong);

  public abstract void modifyPasswordByMobile(String paramString1, String paramString2);

  public abstract List<Map<String, Object>> findMembersForExcle(MemberQuery paramMemberQuery)
    throws BusinessException;
}
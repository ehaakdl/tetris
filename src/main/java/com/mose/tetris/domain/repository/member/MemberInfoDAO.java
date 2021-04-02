package com.mose.tetris.domain.repository.member;

import com.mose.tetris.domain.common.eMemberSt;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="MEMBER_INFO_TB")
@Getter
@NoArgsConstructor
public class MemberInfoDAO {
    @Id
    @Column(name = "member_id")
    private long mMemberId;

    @OneToOne
    @JoinColumn(name = "token_info_id")
    private TokenInfoDAO mTokenInfoDAO;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "member_st")
    private eMemberSt mMemberSt;


}

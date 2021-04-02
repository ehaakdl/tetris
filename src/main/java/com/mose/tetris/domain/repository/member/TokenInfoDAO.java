package com.mose.tetris.domain.repository.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="TOKEN_INFO_TB")
@Getter
@NoArgsConstructor
public class TokenInfoDAO {
    @Id
    @Column(name = "token_info_id")
    private long mTokenInfoId;

    @Column(name = "expire_date")
    private long mExpireDate;

    @Column(name = "token_info_hash")
    private String mTokenInfoHash;

    @OneToOne(mappedBy = "mTokenInfoDAO")
    private MemberInfoDAO mMemberInfoDAO;
}

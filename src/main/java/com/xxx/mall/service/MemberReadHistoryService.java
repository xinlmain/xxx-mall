package com.xxx.mall.service;

import com.xxx.mall.nosql.mongo.document.MemberReadHistory;
import com.xxx.mall.nosql.mongo.repo.MemberReadHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员浏览记录管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
public class MemberReadHistoryService {
    private final MemberReadHistoryRepository memberReadHistoryRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public MemberReadHistoryService(MemberReadHistoryRepository memberReadHistoryRepository) {
        this.memberReadHistoryRepository = memberReadHistoryRepository;
    }

    /**
     * 生成浏览记录
     */
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    /**
     * 批量删除浏览记录
     */
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for(String id:ids){
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    /**
     * 获取用户浏览历史记录
     */
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}

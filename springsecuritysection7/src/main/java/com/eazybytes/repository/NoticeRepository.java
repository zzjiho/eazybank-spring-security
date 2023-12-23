package com.eazybytes.repository;

import com.eazybytes.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt") //시작날짜 - 마지막날짜 사이에 있는 현재 날짜들을 전부 가져옴. 기간지난건 보고싶지 않다는 뜻 ?
    List<Notice> findAllActiveNotices();

}

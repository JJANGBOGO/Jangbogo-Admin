package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.domain.ProductDetailDto;
import com.jangbogo.admin.domain.ProductDto;
import com.jangbogo.admin.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    SqlSession session;                                                                                                 // SqlSession 자동 주입

    private static String namespace="com.jangbogo.admin.dao.ProductMapper.";                                            // 대소문자 구분X

    public int getSearchResultCnt(SearchCondition sc) {                                                                 // 메서드명 : getSearchResultCnt
        return session.selectOne(namespace + "selectResultCnt", sc);                                                    // 기   능 : productMapper.xml에 있는 SQL문을 실행하여 상품내역 수 조회 결과 반환
    }

    public List<ProductDto> getSearchSelectPage(SearchCondition sc) {                                                   // 메서드명 : getSearchSelectPage
        return session.selectList(namespace + "selectAll", sc);                                                      // 기   능 : productMapper.xml에 있는 SQL문을 실행하여 List<ProductDto>를 반환
    }                                                                                                                   // 반환타입 : List<ProductDto> - 매개변수 : SearchCondition sc


    public ProductDetailDto getProductDto(Integer prod_idx) {                                                           // 메서드명 : getProductDto
        return session.selectOne(namespace + "selectProduct", prod_idx);                                             // 기   능 : productMapper.xml에 있는 SQL문을 실행하여 상품상세 조회
    }                                                                                                                   // 반환타입 : ProductDetailDto - 매개변수 : Integer prod_idx


    public int getPendingSearchResultCnt(SearchCondition sc) {                                                          // 메서드명 : getPendingSearchResultCnt
        return session.selectOne(namespace + "selectPendingResultCnt", sc);                                          // 기   능 : productMapper.xml에 있는 SQL문을 실행하여 '승인대기' 상태인 상품내역 수 조회 결과 반환
    }                                                                                                                   // 반환타입 : ProductDetailDto - 매개변수 : SearchCondition sc

    public List<ProductDto> getPendingSearchSelectPage(SearchCondition sc) {                                            // 메서드명 : getPendingSearchSelectPage
        return session.selectList(namespace + "selectPendingAll", sc);                                               // 기   능 : productMapper.xml에 있는 SQL문을 실행하여 '승인대기' 상태인 List<ProductDto>를 반환
    }                                                                                                                   // 반환타입 : ProductDetailDto - 매개변수 : SearchCondition sc
}

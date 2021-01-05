package org.carpenter.domain.recommend;

import lombok.Getter;

@Getter
public enum RecommendType {
    VIDEO("video"), PRODUCT("product");

    private String type;

    RecommendType(String type) {
        this.type = type;
    }
}

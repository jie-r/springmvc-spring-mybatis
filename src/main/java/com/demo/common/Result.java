package com.demo.common;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:查询结果
 * @ClassName :com.cdutcm.common.util.Result.java
 * @Author :lijie
 */
public class Result<E> implements Serializable {
    private static final long serialVersionUID = 9104095185019645352L;
    private Page page;
    private List<E> content;

    public Result(Page page, List<E> content) {
        this.page = page;
        this.content = content;
    }

    public Page getPage() {
        return this.page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<E> getContent() {
        return this.content;
    }

    public void setContent(List<E> content) {
        this.content = content;
    }
}

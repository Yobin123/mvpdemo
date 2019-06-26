package com.example.hybss.mvpdemo.net;

/**
 * 干货集中营相关接口
 *
 * @param <T>
 */
public class GankBaseResponse<T> {
    private String[] category;
    private boolean error;
    private T results;

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }


    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}

package com.modespring.core.domain.pojo;

/**
 * Created by Shawoe on 2015/6/8.
 */
public class Upload {
    private boolean success;
    private String msg;
    private String file_path;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}

package com.hdl.yzx.result;

/**
 * 云之讯登录结果
 * Created by HDL on 2018/10/31.
 */

public class YzxLoginResult {

    private RespBean resp;

    public RespBean getResp() {
        return resp;
    }

    public void setResp(RespBean resp) {
        this.resp = resp;
    }

    public static class RespBean {

        private String respCode;
        private ClientBean client;

        public String getRespCode() {
            return respCode;
        }

        public void setRespCode(String respCode) {
            this.respCode = respCode;
        }

        public ClientBean getClient() {
            return client;
        }

        public void setClient(ClientBean client) {
            this.client = client;
        }

        public static class ClientBean {
            /**
             * clientNumber : 62417122345053
             * clientPwd : a1677e15
             * createDate : 2018-05-02 12:33:34
             * loginToken : eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiYTZhYjdkYzNiOTEzNWJlODQyZTBkOTYxNDliMDZjMDUiLCJBcHBpZCI6IjdjNzllY2JmZjA4ZjQ3YjE5OWY4MjBiNGU3ZWU2MTc3IiwiVXNlcmlkIjoiMTU1MTkwOTk5MjgifQ==.TZ74XbMBRWTT587h0X75IBtCJYxmN4amPmOQM4OkavE=
             * mobile :
             * userId : 15519099928
             */

            private String clientNumber;
            private String clientPwd;
            private String createDate;
            private String loginToken;
            private String mobile;
            private String userId;

            public String getClientNumber() {
                return clientNumber;
            }

            public void setClientNumber(String clientNumber) {
                this.clientNumber = clientNumber;
            }

            public String getClientPwd() {
                return clientPwd;
            }

            public void setClientPwd(String clientPwd) {
                this.clientPwd = clientPwd;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getLoginToken() {
                return loginToken;
            }

            public void setLoginToken(String loginToken) {
                this.loginToken = loginToken;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            @Override
            public String toString() {
                return "ClientBean{" +
                        "clientNumber='" + clientNumber + '\'' +
                        ", clientPwd='" + clientPwd + '\'' +
                        ", createDate='" + createDate + '\'' +
                        ", loginToken='" + loginToken + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", userId='" + userId + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "RespBean{" +
                    "respCode='" + respCode + '\'' +
                    ", client=" + client +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "YzxLoginResult{" +
                "resp=" + resp +
                '}';
    }
}

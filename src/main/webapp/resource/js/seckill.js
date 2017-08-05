/**
 * Created by huzhiming on 2017/7/29.
 */

var secKill = {
    register: {
        formCheck: function () {
            if ($("#username").val() == "") {
                alert("用户名不能为空！");
                return false;
            }
            if ($("#phone").val() == "") {
                alert("手机号不能为空！");
                return false;
            }
            if ($("#pwd").val() == "") {
                alert("密码不能为空！");
                return false;
            }
            if ($("#pwd").val() != $("#compwd").val()) {
                alert("密码前后不一致！");
                return false;
            }
            return true;
        },
        register: function () {
            if (this.formCheck()) {
                $.ajax({
                    type: "POST",
                    url: "register",
                    data: $('#registerForm').serialize(),// 你的formid
                    async: false,
                    error: function (request) {
                        alert("Connection error");
                    },
                    success: function (data) {
                        if (data.status == 200) {
                            alert("注册成功");
                            window.location.href = "loginUI";
                        } else {
                            alert(data.msg);
                        }
                    }
                });
            }
        }
    },
    detail: {
        init: function (killId, nowTime, beginTime, endTime) {
            this.countDown(killId, nowTime, beginTime, endTime);
        },
        countDown: function (killId, nowTime, beginTime, endTime) {
            if (nowTime > endTime) {
                //秒杀结束
                $("#btn_shop").removeClass("btn_now").addClass("btn_over").html("抢购结束");
            }
            else if (beginTime > nowTime) {
                //秒杀未开始
                $("#btn_shop").removeClass("btn_now").addClass("btn_over").html("秒杀未开始");
                var timer = $("#countdown_timer");
                var killTime = new Date(beginTime);
                timer.countdown(killTime, function (event) {
                    var format = event.strftime('秒杀倒计时: %D 天 %H 时 %M 分 %S 秒');
                    timer.html(format);
                }).on("finish.countdown", function () {

                });
            } else {
                //正在秒杀
                this.killHandler(killId);
                var timer = $("#countdown_timer");
                var killTime = new Date(endTime);
                timer.countdown(killTime, function (event) {
                    var format = event.strftime('秒杀剩余时间: %D 天 %H 时 %M 分 %S 秒');
                    timer.html(format);
                }).on("finish.countdown", function () { //计时结束
                    $("#btn_shop").removeClass("btn_now").addClass("btn_over").html("抢购结束");
                });
            }
        },
        killHandler: function (killId) {
            $.ajax({
                type: "post",
                url: "exposeUrl",
                data: {killId: killId},
                success: function (result) {
                    if (result != null && result["isBegin"]) {
                        var btn = $("#btn_shop");
                        btn.removeClass("btn_over").addClass("btn_now").html("抢购");
                        btn.one("click", function () {
                            btn.html("抢购排队中……");
                            $.ajax({
                                type: "post",
                                url: "kill",
                                data: {killId: killId, md5: result["md5"]},
                                success: function (data) {
                                    $("#info").html(data["msg"]).show();
                                    btn.removeClass("btn_now").addClass("btn_over").html("抢购");
                                },
                                error: function () {
                                    $("#info").html("服务器内部错误,请稍后重试!").show();
                                    btn.removeClass("btn_now").addClass("btn_over").html("抢购");
                                },
                            })
                        });
                    } else {
                        this.countDown(killId, result["now"].time, result["beginTime"].time, result["endTime"].time);
                    }
                }
            });


        }

    }
}
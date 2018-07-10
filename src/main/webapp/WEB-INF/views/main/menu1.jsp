<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!-- data-spy="affix" -->
<ul id="main-nav" class="nav nav-tabs nav-stacked " display="none">
    <li class="active" style="margin: 0" id="home"><a> <i class="glyphicon glyphicon-th-large"></i> 首页 </a> </li>
    <li style="margin: 0" id="equipmentMenu"><a href="#secondmenu"  data-toggle="collapse">
        <i class="glyphicon glyphicon-cog"></i> 所有模块
        <%--<span class="pull-right glyphicon glyphicon-chevron-down"></span>--%>
    </a>
        <ul id="secondmenu" class="nav nav-list collapse secondmenu"
            style="height: 0px;">
            <!--
            <li><a href="javascript:pageType()"><i class="glyphicon glyphicon-th-list"></i>新增招聘</a></li>
            <li><a href="javascript:pageStateChart()"><i class="glyphicon glyphicon-user"></i>我的未投</a></li>
            <li><a href="javascript:pageEquipment()"><i class="glyphicon glyphicon-user"></i>我的已投</a></li>
            -->
            <!--
            <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>按设备类型</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-edit"></i>按设备标识</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>安检验情况</a></li> -->
        </ul>
    </li>
    <li style="margin: 0" id="repairMenu"><a href="#repair" data-toggle="collapse">
        <i class="glyphicon glyphicon-cog"></i> 模块操作
        <%--<span class="pull-right glyphicon glyphicon-chevron-down"></span>--%>
    </a>
        <ul id="repair" class="nav nav-list secondmenu" style="height: 0px;">
            <li><a href="javascript:productAudit()"><i class="glyphicon glyphicon-user"></i>权限申请 </a></li>
            <li><a href="javascript:pageRepairHistory()"><i class="glyphicon glyphicon-th-list"></i>新增模块</a></li>
            <li><a href="javascript:copyClipBoard()"><i class="glyphicon glyphicon-th-list"></i>修改模块</a></li>
            <li><a href="javascript:productDeployPage()"><i class="glyphicon glyphicon-th-list"></i>模块部署</a></li>
        </ul>
    </li>
    <%--<span class="pull-right glyphicon glyphicon-chevron-down"></span>--%>
    <!-- 	<li style="margin: 0" id="repairMenu"><a href="javascript:pageRepair()"> <i
                class="glyphicon glyphicon-credit-card"></i> 设备维修
        </a></li> -->
    <!-- <li style="margin: 0"><a href="#"> <i
            class="glyphicon glyphicon-globe"></i> 配件 <span
            class="label label-warning pull-right">5</span>
    </a></li> -->
    <!--
    <li style="margin: 0" id="departmentMenu"><a>
        <i class="glyphicon glyphicon-calendar"></i> 后台管理
    </a></li>
    <li style="margin: 0" id="userMenu"><a href="#account"
                                           class="nav-header collapsed" data-toggle="collapse"> <i
            class="glyphicon glyphicon-cog"></i> 用户管理 <span
            class="pull-right glyphicon glyphicon-chevron-down"></span>
    </a>
        <ul id="account" class="nav nav-list collapse secondmenu"
            style="height: 0px;">
            <li><a href="javascript:pageUser()"><i class="glyphicon glyphicon-user"></i>账户管理</a></li>
            <li><a href="javascript:pageRole()"><i class="glyphicon glyphicon-th-list"></i>角色管理</a></li>
        </ul>
    </li>
    -->
</ul>
<script type="text/javascript">

    function productAudit() {
        $
            .ajax({
                url: "${pageContext.request.contextPath}/productline/productauditpage",
                type: "GET",
                dataType: "html",
                async: false,
                success: function (data) {
                    $('#main').empty();
                    $('#main').html(data);
                },
                error: function () {
                    alert("error");
                }
            });
    }
    function productDeployPage() {
        $
            .ajax({
                url: "${pageContext.request.contextPath}/productline/prodecudeployment",
                type: "GET",
                dataType: "html",
                async: false,
                success: function (data) {
                    $('#main').empty();
                    $('#main').html(data);
                },
                error: function () {
                    alert("error");
                }
            });
    }
    function getInterfacePage(productid) {
        $
            .ajax({
                url:"${pageContext.request.contextPath}/interface/getinterfacepage",
                type:"get",
                dataType:"html",
                data:{
                    "productId":productid
                },
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });

    }
    function pagehtml() {
        $
            .ajax({
                url: "${pageContext.request.contextPath}/productline/queryallproduct",
                type: "get",
                dataType : "json",
                success: function (data) {



                        $
                            .each(
                                data.data,
                                function (j, val) {
                                    var html;
                                    var productid = val.id;
                                    html = "<li><a href=\"javascript:getInterfacePage("+productid+")\"><i class=\"glyphicon glyphicon-th-list\"></i>"+val.productname+" </a></li>";
                                    $("#secondmenu").append(html);

                                });



                },
                error: function (error) {
                    alert("页面出错");
                }
            });
    }
    //用户权限管理
    $(function () {
        $("#userMenu").hide();
        $("#departmentMenu").hide();
        pagehtml();
        <%--var roleName = "${currentUser.roleName}";--%>
        <%--//管理员，最高权限--%>
        <%--if(roleName == "管理员"){--%>
        <%--}--%>
        <%--//维修人员，只能查看设备维修--%>
        <%--else if(roleName == "维修者"){--%>
        <%--$("#equipmentMenu").hide();--%>
        <%--$("#departmentMenu").hide();--%>
        <%--$("#userMenu").hide();--%>
        <%--}--%>
        <%--//用户只能查看设备管理和设备维修--%>
        <%--else if(roleName == "用户"){--%>
        <%--$("#departmentMenu").hide();--%>
        <%--$("#userMenu").hide();--%>
        <%--}--%>
        <%--//其他人权限，暂定--%>
        <%--else{--%>
        <%--$("#departmentMenu").hide();--%>
        <%--$("#userMenu").hide();--%>
        <%--}--%>
   });
    //查询所有部门
    $('#departmentMenu').click(function (event) {
        $(this).addClass("active").siblings().removeClass("active");
        pageDepartment();
    });
    //点击设备管理
    $('#equipmentMenu').click(function (event) {
        $(this).addClass("active").siblings().removeClass("active");
    });
    //切换到department/list.jsp
    function pageDepartment() {
        $
            .ajax({
                url: "${pageContext.request.contextPath}/department/pageDepartment",
                type: "GET",
                dataType: "html",
                async: false,
                success: function (data) {
                    $('#main').empty();
                    $('#main').html(data);
                },
                error: function () {
                    alert("error");
                }
            });
    }
    //切换到equipment/list.jsp
    function pageEquipment() {
        $.ajax({
            url: "${pageContext.request.contextPath}/equipment/pageEquipment",
            type: "GET",
            dataType: "html",
            //true有时会得不到数据
            async: false,
            success: function (data) {
                $('#main').empty();
                $('#main').html(data);
            },
            error: function () {
                alert("error");
            }
        });
    }
    //点击首页
    $("#home").click(function (event) {
        $(this).addClass("active").siblings().removeClass("active");
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/user/home",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    });
    //点击联系人
    $("#userMenu").click(function (event) {
        $(this).addClass("active").siblings().removeClass("active");
    })
    //切换到user/list.jsp
    function pageUser() {
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/user/pageUser",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    }
    //切换到user/roleList.jsp
    function pageRole() {
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/user/pageRole",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    }
    //点击设备维修
    $("#repairMenu").click(function (event) {
        $(this).addClass("active").siblings().removeClass("active");
    })
    //切换到repair/list.jsp
    function pageRepair() {
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/repair/pageRepair",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    }
    //点击维修历史
    function pageRepairHistory() {
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/repair/pageRepairHistory",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    }
    //切换到equipment/type.jsp
    function pageType() {
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/equipment/pageType",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    }
    //切换到equipment/stateChart.jsp
    function pageStateChart() {
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/equipment/pageStateChart",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    }
    //切换到repair/repairChart.jsp
    function pageRepairChart() {
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/repair/pageRepairChart",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    }
    //切换到 复制粘贴文本框
    function copyClipBoard() {
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/repair/copyClipBoard",
                type: "GET",
                datatype: "html",
                success: function (data) {
                    $("#main").empty();
                    $("#main").html(data);
                },
                error: function () {
                    alert("errer");
                }
            });
    }
</script>

<%-- 
    Document   : quanlytk
    Created on : Aug 6, 2023, 1:16:40 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/admin/quanlytaikhoan/themtaikhoan" var="action"/>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="<c:url value="/js/FunctionObject.js" />"></script>
<sec:authorize access="hasRole('ROLE_ADMIN')"> 
    <main class="table">

        <form:form method="post" action="${action}" modelAttribute="nguoidung" enctype="multipart/form-data">
            <%--<form:errors  path="*" element="div" cssClass="alert alert-danger" />--%>
            <div class="container">
                <c:choose>
                    <c:when test="${nguoidung.id == null}"><h1>Thêm tài khoản</h1></c:when>
                    <c:otherwise><h1>Cập nhật tài khoản</h1></c:otherwise>
                </c:choose>
                <form:hidden path="id"/>
                <form:hidden path="avatar"/>

                <label for="name">Họ và tên:</label>
                <!--<label for="name">${nguoidung.id}</label>-->
                <form:input type="text" id="fullname" path="name" />
                <form:errors  path="name" element="div" cssClass="text-danger" />

                <label for="username">Username:</label>
                <form:input type="text" id="username" path="username" />
                <form:errors  path="username" element="div" cssClass="text-danger" />

                <label for="password">Password:</label>
                <form:input type="text" id="password" path="password" />
                <form:errors  path="password" element="div" cssClass="text-danger" />

                <label for="position">Chức vụ:</label>
                <form:select class="form-select" id="role" name="role" path="roleId">
                    <c:forEach items="${roles}" var="r">
                        <c:choose>
                            <c:when test="${r.id == nguoidung.roleId.id}">
                                <option value="${r.id}" selected>${r.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${r.id}">${r.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>

                <label class="label-khoa" for="position">Khoa:</label>
                <form:select class="form-select" id="khoa" name="khoa" path="khoaId">
                    <c:forEach items="${khoas}" var="k">
                        <c:choose>
                            <c:when test="${k.id == nguoidung.khoaId.id}">
                                <option value="${k.id}" selected>${k.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${k.id}">${k.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>

                <label class="label-rank" for="position">Rank:</label>
                <form:select class="form-select" id="rank" name="rank" path="rankId">
                    <c:forEach items="${ranks}" var="ra">
                        <c:choose>
                            <c:when test="${ra.id == nguoidung.rankId.id}">
                                <option value="${ra.id}" selected>${ra.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${ra.id}">${ra.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>

                <form:input type="hidden" path="rankId" />   

                <label for="phone">Số điện thoại:</label>
                <form:input type="text" id="phone" path="phone" />
                <form:errors  path="phone" element="div" cssClass="text-danger" />

                <label for="address">Địa chỉ:</label>
                <form:input type="text" id="address" path="address" />
                <form:errors  path="address" element="div" cssClass="text-danger" />

                <label for="email">Email:</label>
                <form:input type="email" id="email" path="emaill" />
                <form:errors  path="emaill" element="div" cssClass="text-danger" />

                <label for="dod">Ngày sinh:</label>
                <form:input type="date" id="dod" path="dod"/>
                <%--<form:errors  path="emaill" element="div" cssClass="text-danger" />--%>

                <label for="gender">Giới tính:</label>
                <form:select id="sex" path="sex">
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                    <option value="Khác">Khác</option>
                </form:select>

                <label for="file">Avatar:</label>
                <form:input type="file" id="file" path="file"/>
                <%--<form:errors  path="file" element="div" cssClass="text-danger" />--%>

                <c:choose>
                    <c:when test="${nguoidung.id == null}"><input type="submit" value="Lưu thông tin"></c:when>
                    <c:otherwise><input type="submit" value="Cập nhật thông tin" id="btn-update" ></c:otherwise>
                </c:choose>
            </div>

        </form:form>
        <c:choose>
            <c:when test="${nguoidung.id == null}"> <button id="check2"">Check add</button></c:when>
            <c:otherwise><button id="btn-check">Check update</button></c:otherwise>
        </c:choose>



        <input type="hidden" id="checkUrl" value="<c:url value="/api/check"/>">

    </main>
</sec:authorize>
<script>
    window.onload = function () {
        let selected = document.getElementById("role");
        let khoa = document.getElementById("khoa");
        let lbKhoa = document.querySelector("label.label-khoa");
        let rank = document.getElementById("rank");
        let lbRank = document.querySelector("label.label-rank");
        console.log(lbKhoa);
        khoa.hidden = true;
        lbKhoa.hidden = true;
        rank.hidden = true;
        lbRank.hidden = true;
        console.log(selected);
        selected.addEventListener("change", function () {
            let selectedOption = selected.value;
            console.log(selectedOption);
            if (selectedOption == 2)
            {
                console.log("doctor");
                khoa.hidden = false;
                lbKhoa.hidden = false;
                rank.hidden = false;
                lbRank.hidden = false;
            } else {
                console.log("user");
                khoa.hidden = true;
                lbKhoa.hidden = true;
                rank.hidden = true;
                lbRank.hidden = true;
            }
        });
        let check = document.getElementById("btn-check");
        check.addEventListener("click", function () {
            const path = document.getElementById("checkUrl").value; // Retrieve the URL value from the hidden input field
            const usernameInput = document.getElementById("username");
            const username = usernameInput.value;
            const idInput = document.getElementById("id");
            const id = idInput.value;
            checkusernameforupdate(path, username, id);
        });
    };
    let check2 = document.getElementById("check2");
    let button2 = document.getElementById("btn-update");

     button2.disabled=true;
     button2.style.backgroundColor="gray";
    check2.addEventListener("click", function () {
        const path = document.getElementById("checkUrl").value; // Retrieve the URL value from the hidden input field
        const usernameInput = document.getElementById("username");
        const username = usernameInput.value;
        checkusernameforadd(path, username);
        
             button2.disabled = false;
  button2.style.backgroundColor = "green";


    });

    // Kiểm tra giá trị của thuộc tính showErrorMessage

</script>
<style>

    #btn-check{
        position: absolute;
        top:55%;
        right:23%;
    }
    #check2{
        position: absolute;
        top:55%;
        right:23%;
    }
    input#username{
        width: 80%;
    }

    .container {
        max-width: 800px;
        margin: 0 auto;
        padding: 20px;
        border: 0.5px solid #5AAC4E;
        border-radius: 30px;
        background-color: #F5FFFA;

    }
    .content{
        display: flex;
    }
    .left{
        width: 50%;
    }
    h1 {
        text-align: center;
    }

    form {
        margin-top: 20px;
    }

    label {
        display: block;
        margin-top: 10px;
    }

    input[type="text"],
    input[type="password"],
    input[type="email"],
    input[type="date"],
    select {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 100px;
        box-sizing: border-box;
        margin-top: 5px;
    }
    input[type="file"]
    {
        padding-top: 10px;

    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        width: 100%;
        margin-top: 50px;
    }
</style>





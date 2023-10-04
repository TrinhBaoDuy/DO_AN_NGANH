<%-- 
    Document   : saplichlam
    Created on : Aug 30, 2023, 1:19:18 PM
    Author     : Trinh Bao Duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value="/js/FunctionObject.js" />"></script>
<c:url value="/admin/saplichlam" var="action" />
<h1>Trang sắp xếp lịch làm</h1>
<h2>Lịch làm chưa xác nhận</h2>
<div class="tble">

    <table>

        <thead>
            <tr>
                <th>Avatar</th>
                <th>Họ và tên BÁC SĨ</th>
                <th>Ngày Làm</th>
                <th>Ca làm</th>
                <th>Chấp thuận</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lichundonebs}" var="s">
                <tr>
                    <td><img style="height: 40px; width: auto" src="<c:url value="${s.userId.avatar}"/>" alt="Avatar"></td>
                    <td>${s.userId.name}</td>
                    <td>${s.dateSchedule}</td>
                    <td>${s.shiftId.name}</td>
                    <td><c:url value="/api/xacnhanlich" var="apixatnhanlich" />
                        <!--<a href="<c:url value="/admin/saplichlam/xatnhan/${s.id}"/>" class="btn btn-success">Xác nhận</a>-->
                        <button class="btn btn-success" onclick="checklichlam('${apixatnhanlich}', ${s.id}, '${s.dateSchedule}', ${s.userId.roleId.id}, ${s.shiftId.id})">Xác nhận</button></td>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


    <table>


        <thead>
            <tr>
                <th>Avatar</th>
                <th> Họ và tên Y TÁ</th>
                <th>Ngày Làm</th>
                <th>Ca làm</th>
                <th>Chấp thuận</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lichundoneyt}" var="s">
                <tr>
                    <td><img style="height: 40px; width: auto" src="<c:url value="${s.userId.avatar}"/>" alt="Avatar"></td>
                    <td>${s.userId.name}</td>
                    <td>${s.dateSchedule}</td>
                    <td>${s.shiftId.name}</td>
                    <td><c:url value="/api/xacnhanlich" var="apixatnhanlich" />
                        <!--<a href="<c:url value="/admin/saplichlam/xatnhan/${s.id}"/>" class="btn btn-success">Xác nhận</a>-->
                        <button class="btn btn-success" onclick="checklichlam('${apixatnhanlich}', ${s.id}, '${s.dateSchedule}', ${s.userId.roleId.id}, ${s.shiftId.id})">Xác nhận</button></td>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>
<%--<c:if test="${msg != null}">
    <div>
        ${msg}
    </div>
</c:if>--%>

<h2>Lịch làm đã xác nhận</h2>

<table>
    <thead>
        <tr>
            <th>Avatar</th>
            <th>Họ và tên</th>
            <th>Ngày Làm</th>
            <th>Ca làm</th>
            <th>Chấp thuận</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lichdone}" var="s">
            <tr>
                <td><img style="height: 40px; width: auto" src="<c:url value="${s.userId.avatar}"/>" alt="Avatar"></td>
                <td>${s.userId.name}</td>
                <td>${s.dateSchedule}</td>
                <td>${s.shiftId.name}</td>
                <td>
                    <a href="<c:url value="/admin/saplichlam/huy/${s.id}"/>" class="btn btn-success">Hủy</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<h2>Lịch làm của nhân viên</h2>
<table class=" table ">
    <thead>
        <tr>
            <th>Ca/thứ</th>
            <th>THỨ 2 </th>
            <th>THỨ 3</th>
            <th>THỨ 4</th>
            <th>THỨ 5</th>
            <th>THỨ 6</th>
            <th>THỨ 7</th>
            <th>CHỦ NHẬT</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Ca sáng</td>
            <c:forEach items="${dateList}" var="date">
                <c:set var="itemDate">
                    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
                </c:set>
                <td> <c:forEach items="${lichdone}" var="s">
                        <c:if test="${itemDate == s.dateSchedule and s.shiftId.id == 1}">
                            <div>${s.userId.roleId.name.substring(5)}-${s.userId.name}</div>
                        </c:if>
                    </c:forEach>
                </td>
                </c:forEach>
        </tr>
        <tr>
            <td>Ca chiều</td>
            <c:forEach items="${dateList}" var="date">
                <c:set var="itemDate">
                    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
                </c:set>
                <td> <c:forEach items="${lichdone}" var="s">
                        <c:if test="${itemDate == s.dateSchedule and s.shiftId.id == 2}">
                            <div>${s.userId.roleId.name.substring(5)}-${s.userId.name}</div>
                        </c:if>
                    </c:forEach>
                </td>
                </c:forEach>
        </tr>
        <tr>
            <td>Ca đêm</td>
            <c:forEach items="${dateList}" var="date">
                <c:set var="itemDate">
                    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
                </c:set>
                <td> <c:forEach items="${lichdone}" var="s">
                        <c:if test="${itemDate == s.dateSchedule and s.shiftId.id == 3}">
                           <div>${s.userId.roleId.name.substring(5)}-${s.userId.name}</div>
                        </c:if>
                    </c:forEach>
                </td>
                </c:forEach>
        </tr>


    </tbody>
</table>

<style>
    h1{
        margin-top: 30px;
        text-align: center;
    }

    .tble{
        display: flex;
        margin: 4px;
    }

    table {

        width: 100%;
        border-collapse: collapse;
        margin: 20px;

    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    img {
        height: 40px;
        width: auto;
    }

    .btn {
        display: inline-block;
        padding: 6px 12px;
        margin-bottom: 0;
        font-size: 14px;
        font-weight: normal;
        line-height: 1.42857143;
        text-align: center;
        white-space: nowrap;
        vertical-align: middle;
        cursor: pointer;
        border: 1px solid transparent;
        border-radius: 4px;
    }

    .btn-success {
        color: #fff;
        background-color: #5cb85c;
        border-color: #4cae4c;
    }
</style>
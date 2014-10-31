<%-- 
    Document   : add
    Created on : Oct 23, 2014, 1:52:23 PM
    Author     : Bni

--%>
<%--
<form method="POST">
    <div><label>NPP</label> <span><form:input path="npp"/></span></div>
    <div><label>Nama</label> <span><form:input path="nama"/></span></div>
    <div><label>Alamat</label> <span><form:input path="alamat"/></span></div>
    <div><label>Kota</label> <span><form:input path="kota"/></span></div>
    <div><label>Kabupaten</label> <span><form:input path="kabupaten"/></span></div>
    <div><label>Propinsi</label> <span><form:input path="propinsi"/></span></div>
    <div><input type="submit"/>
</form>
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form commandName="karyawanMdl" method="POST">
    <div><label>NPP</label> <span><form:input path="npp"/></span></div>
    <div><label>Nama</label> <span><form:input path="nama"/></span></div>
    <div><label>Alamat</label> <span><form:input path="alamat"/></span></div>
    <div><label>Kota</label> <span><form:input path="kota"/></span></div>
    <div><label>Kabupaten</label> <span><form:input path="kabupaten"/></span></div>
    <div><label>Propinsi</label> <span><form:input path="propinsi"/></span></div>
    <div><input type="submit"/>
</form:form>
<%-- 
    Document   : list
    Created on : Oct 23, 2014, 1:34:29 PM
    Author     : Bni
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Latihan</title>
        <script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-ui/jquery-ui.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/jqGrid/js/jquery.jqGrid.min.js" />"></script>        
        <script type="text/javascript" src="<c:url value="/js/jqGrid/js/i18n/grid.locale-en.js" />"></script>        

        <link rel="stylesheet" type="text/css" href="<c:url value="/js/jquery-ui/jquery-ui.min.css" />" media="screen" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/js/jqGrid/css/ui.jqgrid.css" />" media="screen" />

    </head>

    <script>
        $(document).ready(function() {

           

            jQuery("#gridTbl").jqGrid({
                url: '${pageContext.request.contextPath}/karyawan/listjson.action',
                        datatype: "json",
                colNames: ['Npp','Nama','Alamat','Kota'
                ],
                colModel: [{
                        name: 'npp',
                        index: 'npp',
                        width: 100,
                        sortable: false
                    }, {
                        name: 'nama',
                        index: 'nama',
                        width: 100,
                        sortable: false
                    }, {
                        name: 'alamat',
                        index: 'alamat',
                        width: 400,
                        sortable: false
                    }, {
                        name: 'kota',
                        index: 'kota',
                        width: 200,
                        sortable: false
                    }
                ],
                rowNum: 5,
                rowList: [10, 20, 30],
                pager: '#gridPager',
                viewrecords: true,
                sortable: false,
                shrinkToFit: true,
                caption: "Detail",
                height: 220,
                width:800
            });
            
            $("#gridTbl").jqGrid('setGridParam', { 'serializeGridData':refreshOnBeforeRequest });
            
            $("#searchBtn").click(function (e) {
                 $("#gridTbl").trigger("reloadGrid", [{page:1}]);     
            }); 
            
            function refreshOnBeforeRequest (postData) {

                var newPostData = $.extend(postData, {
                    'searchBy': $("#searchBy").val(),
                    'searchVal': $("#searchVal").val()
                  
                });
                
                return $.param(newPostData);
            };
        });

    </script>
    <body>
        <h1>list</h1>
        Search By 
        <select id="searchBy">
            <option value="npp">Npp</option> 
            <option value="nama">Nama</option>          
        </select>
        
        <input  id="searchVal" /> <input type="submit" value="search" id="searchBtn">
        <table id="gridTbl"></table>
        <div id="gridPager"></div>
    </body>
</html>

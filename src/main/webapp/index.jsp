<%-- 
    Document   : index
    Created on : Dec 12, 2017, 7:52:43 PM
    Author     : ghsmith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ESH Viewer</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>

<script lang="JavaScript">
$(document).ready(function() {

$('#treeView').jstree({
    'core' : {
        'data' : {
            'url' : function(node) {
                return node.id === '#' ?
                    '/eshViewer/webresources/normalizedHierarchy/jsTree' :
                    '/eshViewer/webresources/normalizedHierarchy/jsTree' ;
            },
            'data' : function (node) {
                return node.id === '#' ?
                    { 'parentId' : '.11198634' } :
                    { 'parentId' : node.id } ;
            }
        },
        'themes' : {
            'icons' : false
        }
    }
});

});
</script>

    </head>

    <body>
        <p>
            <form>
                <input type="text" size="30"/> <input type="button" value="Search">
            </form>
        </p>
        <div id="treeView" style="width: 50%; border: 1px solid black;"></div>
    </body>

</html>

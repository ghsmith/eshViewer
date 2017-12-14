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

var rootId = 'd71e8dfe85fa7b59d9bc56cea8d02453';

var searchResultMap = null;

function setNodeSearchState() {
    $($('#treeView').jstree().get_json($('#treeView'), { 'flat' : 'true' })).each(function(index, value) {
        var node = $('#treeView').jstree().get_node(this.id);
        $('#treeView').jstree('set_text', node, node.original.text);
        var searchResult = searchResultMap[this.id];
        if(searchResult != null) {
            $('#treeView').jstree('set_text', node, node.original.text + " (" + searchResult + ")");
        }
    });
    $($('#treeView').jstree().get_json($('#treeView'), { 'flat' : 'true' })).each(function(index, value) {
        $('#treeView').jstree().get_node(this.id, true).css('font-weight', 'normal');
        var searchResult = searchResultMap[this.id];
        if(searchResult != null) {
            $('#treeView').jstree().get_node(this.id, true).css('font-weight', 'bold');
        }
    });
}

$(document).ready(function() {

    $('#treeView').jstree({
        'core' : {
            'data' : {
                'url' : function(node) {
                    return node.id === '#' ?
                        '/eshViewer/webresources/normalizedHierarchyNode/jsTree' :
                        '/eshViewer/webresources/normalizedHierarchyNode/jsTree' ;
                },
                'data' : function (node) {
                    return node.id === '#' ?
                        { 'parentId' : rootId } :
                        { 'parentId' : node.id } ;
                }
            },
            'themes' : {
                'icons' : false
            }
        }
    });

    $('#searchButton').on('click', function() {
        $.ajax({
            'url' : '/eshViewer/webresources/normalizedHierarchyNode/searchResult?searchString=' + $('#searchText').val(),
            'success' : function(result) {
                searchResultMap = result;
                setNodeSearchState();
            }
        });
    });

    $('#treeView').on('after_open.jstree', function (node) {
        setNodeSearchState();
    });

    $(document).keypress(function(event) {
        if(event.which == 13) {
            $('#searchButton').trigger('click');
        }
    });

    $('#treeView').on('select_node.jstree', function (node, selected, event) {
        $('#detailJson').append(JSON.stringify(selected.node.original, null, "\t") + '\n');
        $('#detail').scrollTop($('#detail')[0].scrollHeight - $('#detail')[0].clientHeight);
    });

});

</script>

    </head>

    <body>
        <div id="search" style="width: 80%; height: 5vh; padding-bottom: 5px;">
            <input id="searchText" type="text" size="60"/> <input id="searchButton" type="button" value="Search">
        </div>
        <div id="treeView" style="width: 40%; height: 80vh; border: 1px solid black; display: inline-block; vertical-align: top; overflow-y: auto;"></div>
        <div id="detail" style="width: 40%; height: 80vh; border: 1px solid black; display: inline-block; vertical-align: top; overflow-y: auto;"><pre id="detailJson"></pre></div>
    </body>

</html>

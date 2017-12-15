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

var searchResultMap = {};

function setNodeSearchState() {
    $($('#treeView').jstree().get_json($('#treeView'), { 'flat' : 'true' })).each(function(index, value) {
        var node = $('#treeView').jstree().get_node(this.id);
        if(this.id in searchResultMap) {
            node.li_attr['style'] = 'font-weight: bold;';
            $('#treeView').jstree('set_text', node, node.original.text + " (" + searchResultMap[this.id] + ")");
            $('#treeView').jstree('show_node', node);
        }
        else {
            node.li_attr['style'] = 'font-weight : normal;';
            $('#treeView').jstree('set_text', node, node.original.text);
            if($('#searchHide').is(':checked')) {
                $('#treeView').jstree('hide_node', node);
            }
            else {
                $('#treeView').jstree('show_node', node);
            }
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

    $('#searchHide').on('click', function() {
        setNodeSearchState();
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
        $('#detail').append('<pre style="border: 1px solid black; margin: 5px; background-color: lightgray;">' + JSON.stringify(selected.node.original, null, "\t") + '</pre>');
        $('#detail').scrollTop($('#detail')[0].scrollHeight - $('#detail')[0].clientHeight);
    });

});

    </script>

    </head>

    <body style="font-family: monospace;">
        
        <div id="header" style="width: 96%; padding-bottom: 5px;">
            <p style="font-size: small;">
                ESH Viewer build 20171214 (PRD V500 schema replicate 20171115)<br/>
                <a href="http://github.com/ghsmith/eshViewer">http://github.com/ghsmith/eshViewer</a>
            </p>
            <input id="searchText" type="text" size="60"/> <input id="searchButton" type="button" value="Search"><br/>
            <input id="searchHide" type="checkbox"/> Only show search hits in tree view
        </div>
        <div id="treeView" style="width: 48%; height: 80vh; border: 1px solid black; display: inline-block; vertical-align: top; overflow-y: auto;"></div>
        <div id="detail" style="width: 48%; height: 80vh; border: 1px solid black; display: inline-block; vertical-align: top; overflow-y: auto;">

<p>
Click on a node in the tree view to see detailed information (JSON format) in
this pane. The hierarchy presented here attempts to generalize the event set
hierarchy and extend it to laboratory discrete task assays and primary [order]
mnemonics. The generalization approach is currently optimized for general lab,
so microbiology and blood bank nodes are not well represented below the level of
the event_code node. The queries run against an unmodified replicate of the V500
schema.
</p>

<p>
Searches currently return nodes where the cd attribute (e.g., <i>11199041</i>)
or the text attribute (e.g., <i>ALLRESLTSECT</i>) contain the search string.
Searches are case-insensitive.
</p>

<p>
Note that this can be a challenging hierarchy to conceptualize because the
cardinality of the parent:child relationship is many:many. For example, the
<i>General Lab</i> event_set node (11199037) has at least 5 different parents.
The generalized hierarchy currently contains about 350,000 nodes. This is
reduced to about 300,000 if primary_mnemonic nodes are not considered (the
inclusion of primary_mnemonic nodes in the hierarchy is contrived, but is
convenient for a first implementation). Many of these nodes are not related to
the laboratory.
</p>

<p>
Legend:
    <ul>
        <li>[S] = event_set node</li>
        <li>[C] = event_code node</li>
        <li>[D] = discrete_task_assay node</li>
        <li>[M] = primary_mnemonic node (order)</li>
        <li>(#) = count of search hits for node (recursively evaluated)</li>
    </ul>
</p>

<p>
To-do:
    <ol>
        <li>Extend generalization to better cover microbiology and blood bank nodes.</li>
        <li>Show more detail information in this pane when a node is clicked.</li>
        <li>Attempt to expose "virtual viewing."</li>
        <li>Consider whether or not primary_mnemonic would be better represented
        as detail attribute.</li>
        <li>Searches are currently unconstrained, which is probably unwise.</li>
        <li>More sophisticated searching modalities (e.g., natural language
        search).</li>
    </ol>
</p>

<pre id="detailJson">
</pre>

        </div>
        
    </body>

</html>

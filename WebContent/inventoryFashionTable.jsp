<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wendy's Fashions</title>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {  
    $("#fashions").dataTable( {
        "bProcessing": false,
        "bServerSide": false,
        "sort": "position",
        "sAjaxSource": "./InventoryFashionServlet",
        "aoColumns": [
            { "mData": "type" },
            { "mData": "season" },
            { "mData": "style" },
            { "mData": "color" },
            { "mData": "length" },
            { "mData": "size" },
            { "mData": "designer" },
            { "mData": "locale" },
            { "mData": "inventoryid" },   
        ],
        "columnDefs": [
                       { "visible": true, "targets": 8 }
                     ]
    });
    
    $('#fashions tbody').on('dblclick', 'tr', function () {
        var iid = $('td', this).eq(8).text();
       alert( 'You clicked on '+iid+'\'s row' );
       // window.location.href= "http://www.msn.com" 
        
       	/*
        	var anSelected = fnGetSelected( oTable );
        if ( anSelected.length == 0 ) {
           alert('Please make a selection');
        } else {
           // Get data from the selected row                    
           var aRow = anSelected[0];
           var sFirstName = oTable.fnGetData( aRow, 0 );
           var sLastName = oTable.fnGetData( aRow, 1 );
           var sID = oTable.fnGetData( aRow, 2 );
           alert('You have selected ' + sID);
 		*/
           
    } );
    
  });
</script>

<style>
form {margin-left: 1cm;}
</style>
<style>
tr {font-size: 10px;}
</style>

</head>
<body>
<form action="">
<h2 >Wendy's Mobile Boutique Fashion Items<br><br></h2>
<table width="95%" style="border: 3px;background: rgb(248, 243, 252);"><tr><td>
    <table id="fashions" class="display" cellspacing="0" width="95%">
        <thead>
            <tr>
                <th>Type</th>
                <th>Season</th>
                <th>Style</th>
                <th>Color</th>
                <th>Length</th>
                <th>Size</th>
                <th>Designer</th>
                <th>Location</th>
                <th>inventoryid</th>
            </tr>
        </thead>       
    </table>
    </td></tr></table>
</form>
</body>
</html>

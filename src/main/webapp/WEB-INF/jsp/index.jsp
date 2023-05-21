<!doctype html>
<html lang='en'>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>
<!-- Boxicons CSS -->
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<!-- add the google font in the designe-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@500&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>


<title>Hello, Sandeep!</title>

<script type="text/javascript">

</script>
</head>
<body>
<h2>Fetching products form a json file</h2>

<div id="feedback"></div>


<!-- need to add the empty container that will be populated by the java script file-->

<input type="button" class=".btn1" id="submit1" value="submit">
<!-- 
<script src="js/script.js">



</script> link to javascript files -->


<script>

$(document).ready(function (){

	$("#submit1").click(function (event) {
        event.preventDefault();
		fire_ajax_submit();
	});
	
});

function fire_ajax_submit() {
	
$.ajax({
    type: "POST",
    contentType: "application/json",
    url: "/productInventory/product/fetchProductDetails/",
   // data: JSON.stringify("sandeep"),
    dataType: 'json',
    cache: false,
    timeout: 600000,
    success: function (data) {
    //alert('test');
    console.log("SUCCESS : ", data);
    // var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
    //             + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
    //         $('#feedback').html(json);

    //         console.log("SUCCESS : ", data);
    //         $("#btn-search").prop("disabled", false);


   // var  resPonseArrayTextObject =  JSON.parse(data);
    for (var i=0;i<data.length;i++) {
        console.log(data[i].productId);
        console.log(data[i].title);
       console.log(data[i].description);
       console.log(data[i].imageUrl);
         }
        // array.forEach(element => {
        //    console.log(element.productId);
        // });
        

        },
        error: function(xhr, status, error) {
        var err = eval("(" + xhr.responseText + ")");
        alert(err.Message);
        }

        });
}

</script>
</body>

</html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Maintenance</title>
    <link rel="stylesheet" href="styles/grp3Style.css" type="text/css"/>
</head>
<body>
    
<h1>Product</h1>
<table>
    <tr>
        <th>Code</th>
        <th>Description</th>
        <th class="right">Price</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    <tr>
        <td>
            <form action="" method="">
                <input  name="productCode" value="8601" size="4">
            </form>
        </td>
        <td>86 (the band) - True Life Songs and Pictures</td>
        <td class="right">$14.95</td>
        <td>
            <a href="editProduct.jsp">Edit</a>
        </td>
        <td>
            <a href="deleteProduct.jsp">Delete</a>
        </td>
        </td>
        
    </tr>
    <tr>
        <td>
            <form action="" method="">
                <input  name="productCode" value="pf01" size="4">
            </form>
        </td>
        <td>Paddlefoot - The first CD</td>
        <td class="right">$12.95</td>
        <td>
            <a href="editProduct.jsp">Edit</a>
        </td>
        <td>
            <a href="deleteProduct.jsp">Delete</a>
        </td>
    </tr>
    <tr>
        <td>
            <form action="" method="">
                <input  name="productCode" value="pf02" size="4">
            </form>
        </td>
        <td>Paddlefoot - The second CD</td>
        <td class="right">$14.95</td>
        <td>
            <a href="editProduct.jsp">Edit</a>
        </td>
        <td>
            <a href="deleteProduct.jsp">Delete</a>
        </td>
    </tr>
    <tr>
        <td>
            <form action="" method="">
                <input  name="productCode" value="jr01" size="4">
            </form>
        </td>
        <td>Joe Rut - Genuine Wood Grained Finish</td>
        <td class="right">$14.95</td>
        <td>
            <a href="editProduct.jsp">Edit</a>
        </td>
        <td>
            <a href="deleteProduct.jsp">Delete</a>
        </td>
    </tr>
</table>
    <br>
    <form action="addProduct.jsp" method="post"> 
        <input type="submit" value="Add To Cart">
    </form>
        
</body>
</html>
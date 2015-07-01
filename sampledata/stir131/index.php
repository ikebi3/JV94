<?php
	if(isset($_POST['selectChar'])){
		$char = $_POST['selectChar'];
	}else{
		$char = 'utf-8';
	}
	
	header("Content-type: text/html; charset=".$char);
	echo "Set Character Set to ".$char."<br>\n";
	
	switch($char){
		case "Shift_JIS"	:$dbChar = "sjis";	break;
		case "UTF-8"		:$dbChar = "utf8";	break;
		case "EUC-JP"		:$dbChar = "ujis";	break;
		case "WINDOWS-31J"	:$dbChar = "sjis";	break;
		case "CP932"		:$dbChar = "cp932";	break;
	}

	$con = mysql_connect("localhost", "root");
	$db		= "langtest";
	
	mysql_select_db($db);
	mysql_set_charset($dbChar);
	
	$query	= "select * from t;";
	
	$result	= mysql_query($query);
	$resultNum = mysql_num_rows($result);
	echo $resultNum."件見つかりました<br>\n";
	
	echo "<table border=1>\n";
//// フィールド設定
	$numField = mysql_num_fields($result);
	for($i=0; $i<$numField; $i++){
		echo "<td>".mysql_field_name($result, $i);
	}
	echo "</tr>\n";
	
//// 表作成	
	for($i=0; $i<$resultNum; $i++){
		$row = mysql_fetch_array($result, MYSQL_NUM);
		foreach($row as $j){
			echo '<td>'.$j."</td>\n";
		}
		echo "</tr>\n";
	}

	mysql_close($con);

?>

<Form method="POST">
<SELECT name="selectChar">
<OPTION value="Shift_JIS">Shift_JIS</OPTION>
<OPTION value="UTF-8">UTF-8</OPTION>
<OPTION value="EUC-JP">EUC-JP</OPTION>
<OPTION value="WINDOWS-31J">WINDOWS-31J</OPTION>
<OPTION value="CP932">CP932</OPTION>
<!-- <OPTION value=""></OPTION>
<OPTION value=""></OPTION>
-->

<INPUT type="submit" value="set" name="submit1">
</Form>

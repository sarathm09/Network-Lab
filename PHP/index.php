<?php
	$file = "details.xml";
	$data_available = 0;


	if(!file_exists($file)){
		$handle = fopen($file, "w");
		fwrite($handle, "<details></details>");
		fclose($handle);
	}
	else if(isset($_POST['sbmt'])){
		$data_available = 1;
		if(validate()){
			process($file);
		}
		else{
			print_error();
		}
	}

	function validate(){
		if(is_numeric($_POST['m1'])&&is_numeric($_POST['m2'])&&is_numeric($_POST['m3']))
			return true;
		else
			return false;
	}

	function process($file){
		$mark = (int)$_POST['m1'] + (int)$_POST['m2'] + (int)$_POST['m3'];
		$details = simplexml_load_file($file);
		$entry = $details->addChild("entry");
		$entry->addChild("name",$_POST['name']);
		$entry->addChild("roll",$_POST['roll']);
		$entry->addChild("total",$mark);
		$entry->addChild("rank","-1");
		$marks = $entry->addChild("marks");
		$marks->addChild('mark1',$_POST['m1']);
		$marks->addChild('mark2',$_POST['m2']);
		$marks->addChild('mark3',$_POST['m3']);
		$details->asXML($file);
		rank($file);
	}

	function rank($file){
		$details = simplexml_load_file($file);
		foreach ($details->entry as $stud) {
			$mark_list[(string)$stud->name] = (int)$stud->total;
		}
		arsort($mark_list);
		foreach ($details->entry as $stud){
			$i = 0;
			foreach ($mark_list as $name => $mark) {
				$i++;
				if($name == $stud->name){
					$stud->rank = $i;
					break;
				}
			}
		}
		$details->asXML($file);
	}

	function print_error(){

	}
?>
<html>
	<head>
		<title>Student Details</title>
		<style>
			body{
				background: #00F;
			}
			#heading{
				color:#ffffff;
				font-style: oblique;
			}
			.aligncenter{
				margin:auto;
				padding:5px;
			}
			.lb{
				width:80%;
				float: left;
				color:#ffffff;
				margin-left: 200px;
			}
			.ip{
				width:30%;
				float: right;
				color:#ffffff;
				border-color: #D2691E;
				background: transparent;
				margin-right: 200px;
			}
			#sbmt{
				color:#ffffff;
				border-color: #D2691E;
				background: transparent;
				margin-top: 100px;
			}
			a{
				color:#ffffff;
			}
			#summary{
				color:#ffffff;
				border-color: #D2691E;
				background: rgba(184, 182, 216, 0.35);
				margin:auto;
				box-shadow: 5px 5px 5px #888888;
			}
		</style>
	</head>
	<body>
		<div class="aligncenter" style="width:60%;">
		<h1 id="heading"><center>Student Details Form</center></h1>
		<br/><hr style="width:80%; color:#D2691E"/><br/>
		<?php
		$mark_list['temp'] = "";
		if(isset($_POST['sbmt'])){
			unset($mark_list['temp']);
			$details = simplexml_load_file("details.xml");
			foreach ($details->entry as $stud) {
				$mark_list[(string)$stud->name] = (int)$stud->total;
			}
			arsort($mark_list);
			print '<table style= "color:#ffffff; margin:auto; border-color:#f0f0f0;" border="1"><tr><th width="300"> name</th><th width="300">mark</th>';
			foreach($mark_list as $name=>$mark){
				print '<tr><td>'.$name.'</td><td>'.$mark.'</td></tr>';
			}
			print '</table>';
			foreach($mark_list as $name=>$mark){
				 print '<br/><br/><div id="summary"><h1><center>SUMMARY</center></h1><h3><center>The top scorer is '.$name.' with '.$mark.' marks.</center></h3><br/>
				 		<p><center>View the xml <a href="details.xml" target="_blank">here</a></center></p></div>';
				 break;
				}
		}
		else{
			print '<form action="" method="post" class="aligncenter" style="width:100%;">
			<p class="lb">Name
			<input type="text" class="ip" name="name" required/></p>
			<p class="lb">Roll
			<input type="text" class="ip" name="roll" required/></p>
			<p class="lb">Mark 1
			<input type="text" class="ip" name="m1" required/></p>
			<p class="lb">Mark 2
			<input type="text" class="ip" name="m2" required/></p>
			<p class="lb">Mark 3
			<input type="text" class="ip" name="m3" required/></p>
			<br/>
			<center>
				<input type="submit" id="sbmt" name="sbmt" value="Submit"/>
			</center>
			</form>';
		}
		?>
		</div>

	</body>
</html>
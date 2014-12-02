#!c:/perl/bin/perl.exe -w
use CGI ":standard";

print header;
print start_html("Thankyou");
$name= param("name");
$roll= param("roll");
$sub= param("sub");
open(OP, ">>output.txt");
open(IP, "<sc.txt");
read(IP,$temp,100);
@vals = split(","$temp);
$o1 = (int) $vals[0];
$o2 = (int) $vals[1];
$o3 = (int) $vals[2];
if($sub == "o1"){
	$o1+=1;
}
elif($sub == "o2"){
	$o2+=1;
}
else{
	$o3+=1;
} 
close IP;
print  OP " Name : $name";
print  OP " Roll  : $roll";
print  OP " Subject : $sub";
close OP;
open(OP, ">sc.txt");
$text = "$o1,$o2,$o3";
print  OP $text;
close OP;
if($o1>$o2) {
	if($o1>$o3){
		print "<br/><br/><h1><center>From the obtained results, we can conclude that OPTION 1 has greater demand</center></h1>";
	}
	else{
		print "<br/><br/><h1><center>From the obtained results, we can conclude that OPTION 3 has greater demand</center></h1>";
	}
}
elif($o2>$o3){
	print "<br/><br/><h1><center>From the obtained results, we can conclude that OPTION 2 has greater demand</center></h1>";
}
else{
	print "<br/><br/><h1><center>From the obtained results, we can conclude that OPTION 3 has greater demand</center></h1>";
}


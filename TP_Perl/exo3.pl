use strict;
use warnings;
print "Entrer un password:  ";
my $pass= <>;
chomp $pass;

if ($pass eq "s'il te plait"){
	print "Accée Autorisée \n";
	print "Bienvenue \n";
}else{
	print "Accée denied \n";
}
print "Appuyer sur Entrer pour quitter";
<>; 

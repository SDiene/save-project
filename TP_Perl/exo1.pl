# application sur la punition à l'école 
use strict;
use warnings;
print "Entrer une phrase de punition que vous vouler repeter:\n";
my $phrase=<>;
chomp $phrase;
print "Veillez entrer le nombre de repetition:\n";
print "\n";
my $nbr=<>;
chomp $nbr;
print '-'x70 ."\n";
print $phrase x $nbr;

<>;

#--- Perl surnommé rouleau de scotcher de l'internet est un language de script comme php python java et Ruby capable de faire communiquer des programmes afin de construre un systeme puissant
#Les avantages d'un language de script donc c'est facile à maintenir et à corriger sans intyervention d'un complitateur qui peut prendre du temps elles servent à rendre Perl moins permissif,ce qui nous sera extrêmement utile pour détecter rapidement de nombreuses erreurs dans le code

use strict;
use warnings;
print"Je suis un code perl\n";
#permet de mettre le programme en pause <>;
# Pour declarer une variable on fait my $"nom" = ....; alors my est un mot-clé
my $nom ="Mr Senghor";
print"Bonjour $nom est ce que vous allez bien!!!!\n";
# Les variables sont juste des conteneurs dans recipents dans lesquels on peut mettre des objets
# Do what I mean Notion de typage avec texte et numérique(impossible)-- Entier et Décimal
# Puissance comme 4  2=16 et Racine carré 4 = 2
my $puissance= 4 ** 2;
print "La puissance de 4 ** 2 est égal à: $puissance\n";
print"Comment vous appellez Mr:\n";
my $prenom= <>;
chomp $prenom; # retrait à chaud 
print"Bonjour Mr $prenom naka tay!!!\n";
# Caluculer la longueur d'une chaine de caractéres avec length
my $chaine = "coolympique";
my $longueur = length $chaine;
print "La chaine '$chaine' contient $longueur caracteres.\n";
# Les programmeurs sont des gens flemmards qui n'aimeent pas se répéter
print "I am a web developper \n" x 2;
# Concatenation avec (.)
my $chaine1 = 'Colom'.'bia';
print"La concaténation de Colom & bia donne $chaine1 \n";
# creer une application avec ipunish
# proposition predicat avec password
# Un boolean ets un objet qui peut prendre que 2 valeurs vraix ou faux
#le nombre 0 en Perl est évalué comme étant faux, alors que toutes les autres valeurs numériques différentes de 0 sontévaluées comme vraies. De même, toutes les chaînes de caractères sont évaluées comme vraies, hormis la chaîne vide (""), ainsi que la chaîne "0".
my $a=4, $b=6;
print "$a > $b :". int($a > $b). "\n";
print "$a < $b :". int($a < $b). "\n";
# Une chaîne $a est plus petite qu'une chaîne $b si $a est rangée avant $b dans l'ordre alphabétique.(lt:lesser than,gt:greater than,eq:equals,ne:not equal !=,le:lesser or equal <=,ge:greater or equal >=)
#La négation en boolean
print "!0 : " . int (!0) . "\n";
print "!1 : " . int (!1) . "\n";
# La difference entre les opérateurs de comparaison (opérateurs && et || des opérateurs and et or: c'est juste leur precedence qui definie leur priorité. Elle détermine l'ordre dans lequel les expressions sont évaluées.)
# On peut utiliser la fonction int pour afficher les résultats des expressions et le ou exclusif ou XOR donne 
# +*-=- comme en TS exemple 
print '0 XOR 0 : '. int(0 xor 0). "\n"; # etc .....
# La fonction defined permet de vérifier qu'une variable est définie donc avec une affectation de valeur precise
#Si ce n'est pas le cas, on dit que la variable n'est pas définie, et on symbolise sa valeur par la valeur spéciale undef
my $var;
# $var est déclarée, mais elle n'est pas définie
print 'defined $var : ' . int (defined $var) . "\n";
$var = 42;
# $var est maintenant définie
print "\$var = $var \n";
print 'defined $var : ' . int (defined $var) . "\n";
$var = undef; # $var n'est maintenant plus définie
print "\$var = undef \n";
print 'defined $var : ' . int (defined $var) . "\n";
# Autre exemple plus avancé 
my $error = "\$var n'est pas définie.\n";
my $var;
# $var est déclarée, mais elle n'est pas définie
defined $var && print "\$var = $var\n" or print $error;
$var = 42; # $var est maintenant définie
defined $var && print "\$var = $var\n" or print $error;
$var = undef; # $var n'est maintenant plus définie
defined $var && print "\$var = $var\n" or print $error;







print "Appuyer sur Entrer pour quitter";
<>; # est un element de syntaxe servant à lire dans un flux données (<> = <STDIN>)

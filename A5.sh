#!/bin/sh
#Bourne Again script
FILE="./pokemon.csv"

if [ ! -f $FILE ]; then
   echo ERROR! FILE DOES NOT EXIST!
   exit 1
fi

while read LINE
do
    TYPE_ONE=`echo $LINE | cut -d, -f3`
    
    if [ ! -f $TYPE_ONE ]; then
        TYPE_FILE=$TYPE_ONE
        TYPE_FILE+=".csv"
        mkdir $TYPE_ONE && touch $TYPE_ONE/$TYPE_FILE
        echo $LINE >> $TYPE_ONE/$TYPE_FILE
    fi
    
done < $FILE

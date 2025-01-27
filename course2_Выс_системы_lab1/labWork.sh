#!/bin/bash

echo "laba started"

#getting file

workfile=$1
exitVar=""

tfile=./tmpfile
touch $tfile

while [ ! -f $workfile ] 
    do
    echo Файл $workfile не найден!
    echo Введите имя файла:
    read workfile
    done



#work with file

while [ ! exitVar = "exit" ]
    do
    lines=`cat $workfile | wc -l`
    echo ""
    echo ""
    echo Работаем с файлом $workfile, количество строк - $lines.
    echo Выберите нужный вариант и введите его номер:
    echo 1. Вывод файла
    echo 2. Удалить строку из файла по номеру
    echo 3. Дописать данные в файл
    echo 4. Выход


    read editCommand

    if [ $editCommand -eq 1 ]
    then
        cat -n $workfile
    elif [ $editCommand -eq 2 ]
    then
        while [[ ! $lineToRemove =~ ^([0-9]+)$ ]]
        do
            echo Введите номер строки:
            read lineToRemove
            if [ $lineToRemove -le $lines ] 
            then
                sed -e ${lineToRemove}d $workfile > $tfile
                cat $tfile > $workfile
                echo Строка ${lineToRemove} удалена
            else
                echo Номер строки не может быть больше строк в файле!
            fi
        done
        lineToRemove=""
    elif [ $editCommand -eq 3 ]
    then
        echo Введите строку для записи в ${workfile}:
        read lineToAdd
        echo $lineToAdd >> $workfile
    else
        break
    fi
    done

rm $tfile


var1=5
while [ $var1 -gt 0 ]
do
echo $var1

#var1=$[ $var1-1 ]
var1=$[ $var1 - 1 ]

done

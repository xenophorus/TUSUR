#!/bin/sh

tempFile=./tmpfile
touch $tempFile

echo Введите имя файла:
read -r workFile

while true
  do
    if [ -f $workFile ]
    then
      break
    else
      echo Файл $workFile не найден!
      echo Введите корректное имя файла:
      read -r workFile
    fi
  done

while true
  do
  lines=$(cat $workFile | wc -l)
  echo ""
  echo Работаем с файлом $workFile, количество строк - $lines.
  echo Выберите нужный вариант и введите его номер:
  echo 1. Вывод файла
  echo 2. Удалить строку из файла по номеру
  echo 3. Дописать данные в файл
  echo 4. Выход

  read -r editCommand

  if [ $editCommand -eq 1 ]
  then
    cat -n $workFile
  elif [ $editCommand -eq 2 ]
  then
    while [[ ! $lineToRemove =~ ^([0-9]+)$ ]]
    do
      echo Введите номер строки:
      read -r lineToRemove
      if [ $lineToRemove -le $lines ]
      then
        sed -e ${lineToRemove}d $workFile > $tempFile
        cat $tempFile > $workFile
        echo Строка ${lineToRemove} удалена
      else
        echo Номер строки не может быть больше строк в файле!
      fi
    done
    lineToRemove=""
  elif [ $editCommand -eq 3 ]
  then
    echo Введите строку для записи в ${workFile}:
    read -r lineToAdd
    echo $lineToAdd >> $workFile
  elif [ $editCommand -eq 4 ]
  then
    break
  else
    continue
  fi
  done

rm $tempFile

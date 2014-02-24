#!/bin/bash
# $Id: app.sh 314274 2004-05-24 21:04:46Z geiseri $
# mp3 - Copyright (C) 2008 root <root@localhost>

MusicRoot="/mnt/WinE/music"

hello()
{
	if [ $1 ]
	then
		echo "Music dir is $1"
		MusicRoot=$1
	else
		echo "Music dir is $MusicRoot"
	fi
 }
 

 play()
 {
 	list ${s}/*
	for s in $@
	do
		#目录或文件名中有空格，出现问题
		#echo $s \$s
		if [ -d $s ]
		then
			play ${s}/*
		elif [ -f $s ]
		then
			echo "playing ...   $s"
			java -jar ~/mp3player.jar $s
		fi
	done
}


list()
{
	t=$@
	for tt in $t
	do
		echo "included files " $tt*
	done
}


 hello $@
 play ${MusicRoot}/*
 
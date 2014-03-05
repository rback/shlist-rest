#!/bin/bash

function load_personal_configs() {
  test -f ~/.sbtconfig && . ~/.sbtconfig
}

function enable_debug_if_needed() {
  DEBUG_PORT=5555
  if [ -n "$DEBUG" ];then
    DEBUG_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT"
  else
    echo -e "Debug disabled. Enable it by adding \033[0;33mDEBUG=true\033[0m into the start command"
  fi
}

load_personal_configs
enable_debug_if_needed

export SBT_OPTS="-XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256M"
exec java -XX:MaxPermSize=256M -Xmx512M ${DEBUG_OPTS} -jar project/sbt-launch.jar "$@"

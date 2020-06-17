#!/usr/bin/env bash

#Based off alpas.sh by ashokgelal which is available here https://gist.github.com/ashokgelal/c569e2df7e296378c8becce1c8680f31

#Include this in the root of your project - then on Heroku you can enter `heroku run ./run_prod.sh db:migrate` to run the migrations if the environment you are on is short on space

runApp() {
    MY_PATH=$(dirname "$0")
    MY_PATH=$( (cd "$MY_PATH" && pwd))
    APP_PATH="${MY_PATH}"

    export alpas_run_mode="console"
    export alpas_root_dir="$APP_PATH"

#Make sure you rename app.jar to the name of your compiled jar file!
    java -jar fireplace.jar $*

    unset alpas_run_mode
    unset alpas_root_dir
}

if [[ $# -eq 1 ]]; then
  case "$1" in
  help)
      runApp --help
      ;;
  *)
      runApp "$@"
      ;;
  esac
else
  runApp "$@"
fi
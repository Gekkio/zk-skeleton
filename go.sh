#!/bin/sh

sbt container:start ~compile:products container:stop

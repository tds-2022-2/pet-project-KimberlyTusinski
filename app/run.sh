#!/bin/bash
gradle --stop
gradle build --continous --1uiet & 
gradle bootRun
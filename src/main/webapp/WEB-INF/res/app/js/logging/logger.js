'use strict';

/* Appenders implementations */
function Appender() {
	
}

Appender.prototype.write = function(level, message){}

	/* Console appender */
function ConsoleAppender() {
	
}

ConsoleAppender.prototype = Object.create(Appender.prototype);
ConsoleAppender.prototype.constructor = ConsoleAppender;

ConsoleAppender.prototype.write = function(level, message){
	console.log(level + ':' + message);
}

/* Logger itself. Finally... */
function Logger() {
	
}

Logger.prototype.trace = function(message){}
Logger.prototype.debug = function(message){}
Logger.prototype.info = function(message){}
Logger.prototype.warn = function(message){}
Logger.prototype.error = function(message){}
Logger.prototype.fatal = function(message){}
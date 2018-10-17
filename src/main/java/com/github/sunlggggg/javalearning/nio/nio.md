http://tutorials.jenkov.com/java-nio/index.html
#nio 
Java NIO(No blocking IO) three main factors. 
<strong>Channel</strong>
<strong>Buffer</strong>
<strong>Selector</strong>
###Channel
the Channel are similar to the streams 
we can use it to write data to the Buffer 
and read data from the Buffer
###Buffer
field: 
1.position
2.limit:use for the read mode, 
3.capacity:the max size  
flip()
write mode (channel to the buffer) translate to read mode(buffer to channel)

rewind() 
###Selector
allow the signal thread to deal with multiple channel







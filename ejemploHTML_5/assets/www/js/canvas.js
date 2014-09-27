
/*** CANVAS ***/
//canvas es la pantalla e dibujo
var img_ball = new Image();
img_ball.onload = initBrush;
img_ball.src = 'images/brushes/brush2.png';
ofsX = 0;
ofsY = 0;

function initCanvas() {
	temp=document.getElementById('canvas');
	ctxCanvas=temp.getContext('2d');
	ctxCanvas.canvas.width = WIN_WDT;
	ctxCanvas.canvas.height = WIN_HGT - TOOLBAR_HGT;
	ctxCanvas.canvas.style.background = '#FFFFFF';
	ctxCanvas.canvas.addEventListener('mousedown', canvas_mousedown, false);
	ctxCanvas.canvas.addEventListener('mousemove', canvas_mousemove, false);
	ctxCanvas.canvas.addEventListener('mouseup', canvas_mouseup, false);
	ctxCanvas.canvas.addEventListener('touchstart', canvas_touchstart, false);
	ctxCanvas.canvas.addEventListener("touchmove", canvas_touchmove, false);
	ctxCanvas.canvas.addEventListener('touchend', canvas_touchend, false);
	ctxCanvas.canvas.addEventListener('touchcancel', canvas_touchend, false);
	ctxCanvas.textBaseline = 'top';
	ctxCanvas.fillStyle = '#000';

	
}

function initBrush() {
	brush = document.createElement('canvas');
	ctxBrush = brush.getContext('2d');
	ctxBrush.canvas.width = img_ball.width;
	ctxBrush.canvas.height = img_ball.height;
	ctxBrush.drawImage(img_ball, 0, 0);
	ctxBrush.transform(2.0, 0, 0, 2.0, 0, 0);
	ctxSetAlpha(ctxBrush);
	ctxSetColor(ctxBrush);
	ofsX = -(ctxBrush.canvas.width >> 1);
	ofsY = -(ctxBrush.canvas.height >> 1);
}

function canvas_mousedown(event) {
    canvas_pressed(event.pageX, event.pageY);
}

function canvas_touchstart(event) {
	event.preventDefault();
	var touch = event.changedTouches[0];
	canvas_pressed(touch.pageX, touch.pageY);
}

function canvas_pressed(x,y) {
	if(x || y) {
		mousedown = true;
		currX = x;
		currY = y - TOOLBAR_HGT;
		lastX = currX;
		lastY = currY;
		drawPixel(currX, currY);
	}
}

function canvas_mousemove(event) {
	if( mousedown ) {
	    canvas_dragged(event.pageX, event.pageY);
	}
}

function canvas_touchmove(event) {
	if( mousedown ) {
		event.preventDefault();
	    var touch = event.changedTouches[0];
	    canvas_dragged(touch.pageX, touch.pageY);
	}
}

function canvas_dragged(x,y) {
 	if(x || y) {
 		currX = x;
 		currY = y - TOOLBAR_HGT;
		drawLine();
 		lastX = currX;
 		lastY = currY;
 	}
}

function canvas_mouseup(event) {
	canvas_release(0,0);
}

function canvas_touchend(event) {
	canvas_release(0,0);
}

function canvas_release(x,y) {
	mousedown = false;
}

function drawPixel(x,y) {
	ctxCanvas.drawImage(brush, x + ofsX, y + ofsY);
}

function drawLine() {
	lenX = currX - lastX;
	lenY = currY - lastY;
	vx = 0;
	if(lenX > 0) {
		vx = 1;
	} else if(lenX < 0) {
		vx = -1;
	}
	vy = 0;
	if(lenY > 0) {
		vy = 1;
	} else if(lenY < 0) {
		vy = -1;
	}
	len = 0;
	lenX = Math.abs(lenX);
	lenY = Math.abs(lenY);
	if(lenX > lenY) {
		vy = (lenY / lenX) * vy;
		len = lenX;
	} else {
		vx = (lenX / lenY) * vx;
		len = lenY;
	}
	x = lastX;
	y = lastY;
	for(i=0; i < len; i++) {
		drawPixel(Math.floor(x),Math.floor(y));
		x += vx;
		y += vy;
	}
}

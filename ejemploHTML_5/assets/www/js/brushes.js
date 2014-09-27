
/*** BRUSHES DIALOG ***/
//brushes la pantalla de la brocha


BRUSHES_BTN_Y = 32;
BRUSHES_BTN_MAX = 4;
BRUSHES_BTN_LEFT = 0;
BRUSHES_BTN_RIGHT = 1;
BRUSHES_BTN_OK = 2;
BRUSHES_BTN_CANCEL = 3;

var brushes_btn_pos = new Array(BRUSHES_BTN_MAX);
var brushes_btn_label = ['-','+','Ok','Cancel'];

function initBrushes() {
	temp=document.getElementById('brushes');
	ctxBrushes=temp.getContext('2d');
	ctxBrushes.canvas.width = WIN_WDT;
	ctxBrushes.canvas.height = WIN_HGT;
	ctxBrushes.font = 'bold 16px Myriad Pro';
	ctxBrushes.textBaseline = 'top';
	drawBrushes();
	initBrushesButtons();

	ctxBrushes.canvas.addEventListener('mousedown', brushes_mousedown, false);
	ctxBrushes.canvas.addEventListener('mousemove', brushes_mousemove, false);
	ctxBrushes.canvas.addEventListener('mouseup', brushes_mouseup, false);
	ctxBrushes.canvas.addEventListener('touchstart', brushes_touchstart, false);
	ctxBrushes.canvas.addEventListener('touchmove', brushes_touchmove, false);
	ctxBrushes.canvas.addEventListener('touchend', brushes_touchend, false);
	ctxBrushes.canvas.addEventListener('touchcancel', brushes_touchend, false);
}

function initBrushesButtons() {
	brushes_btn_pos[0] = [200,BRUSHES_BTN_Y];
	brushes_btn_pos[1] = [340,BRUSHES_BTN_Y];
	brushes_btn_pos[2] = [600,BRUSHES_BTN_Y];
	brushes_btn_pos[3] = [720,BRUSHES_BTN_Y];
	drawButton(ctxBrushes, brushes_btn_pos[BRUSHES_BTN_LEFT][0], brushes_btn_pos[BRUSHES_BTN_LEFT][1], brushes_btn_label[BRUSHES_BTN_LEFT], false);
	drawButton(ctxBrushes, brushes_btn_pos[BRUSHES_BTN_RIGHT][0], brushes_btn_pos[BRUSHES_BTN_LEFT][1], brushes_btn_label[BRUSHES_BTN_RIGHT], false);
	drawButton(ctxBrushes, brushes_btn_pos[BRUSHES_BTN_OK][0], brushes_btn_pos[BRUSHES_BTN_LEFT][1], brushes_btn_label[BRUSHES_BTN_OK], false);
	drawButton(ctxBrushes, brushes_btn_pos[BRUSHES_BTN_CANCEL][0], brushes_btn_pos[BRUSHES_BTN_LEFT][1], brushes_btn_label[BRUSHES_BTN_CANCEL], false);
}

function drawBrushes() {
	ctxBrushes.fillStyle = '#FFFFFF';
	ctxBrushes.fillText('Brush Size', 120, 38);
	drawWidth();
}

function drawWidth() {
	ctxBrushes.fillStyle = '#404040';
	ctxBrushes.fillRect(288, 38, 48, 20);
	ctxBrushes.fillStyle = '#FFFFFF';
	ctxBrushes.fillText(lineTmp+' px', 288, 38);
}

function brushes_mousedown(event) {
    brushes_pressed(event.pageX, event.pageY);
}

function brushes_touchstart(event) {
	event.preventDefault();
	var touch = event.changedTouches[0];
	brushes_pressed(touch.pageX, touch.pageY);
}

function brushes_pressed(x,y) {
	if(x || y) {
		mousedown = true;
		// if( inside(x, y, BRUSHES_X, BRUSHES_Y, BRUSHES_WDT, BRUSHES_HGT) ) {
		// 	selectColor(x,y);
		// } else {
			buttonIdx = -1;
			for(i=0; i < BRUSHES_BTN_MAX; i++) {
				if( inside(x, y, brushes_btn_pos[i][0], brushes_btn_pos[i][1], BUTTON_WDT, BUTTON_HGT)  ) {
					buttonIdx = i;
					break;
				}
			}
			if( buttonIdx > -1 ) {
				drawButton(ctxBrushes, brushes_btn_pos[buttonIdx][0], brushes_btn_pos[buttonIdx][1], brushes_btn_label[buttonIdx], true);
			}
		// }
	}
}


function brushes_mousemove(event) {
    brushes_dragged(event.pageX, event.pageY);
}

function brushes_touchmove(event) {
	event.preventDefault();
	var touch = event.changedTouches[0];
	brushes_dragged(touch.pageX, touch.pageY);
}

function brushes_dragged(x,y) {
}

function brushes_mouseup(event) {
	brushes_released(0,0);
}

function brushes_touchend(event) {
	brushes_released(0,0);
}

function brushes_released(x,y) {
	mousedown = false;
	if( buttonIdx > -1 ) {
		drawButton(ctxBrushes, brushes_btn_pos[buttonIdx][0], brushes_btn_pos[buttonIdx][1], brushes_btn_label[buttonIdx], false);
		brushes_action(buttonIdx);
	}
}

function brushes_action(idx) {
	switch(idx) {
		case BRUSHES_BTN_LEFT:
			if( lineTmp > 2 ) {
				lineTmp -= 2;
				drawWidth();
			}
			break;
		case BRUSHES_BTN_RIGHT:
			if( lineTmp < 32 ) {
				lineTmp += 2;
				drawWidth();
			}
			break;
		case BRUSHES_BTN_OK:
			lineWidth = lineTmp;
			radius = Math.floor(lineWidth /2);
			document.getElementById('brushes').style.display = 'none';
		break;
		case BRUSHES_BTN_CANCEL:
			document.getElementById('brushes').style.display = 'none';
		break;
	}
}



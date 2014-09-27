
/*** PALETTE DIALOG ***/
//palette la pantalla de colores
COLOR_WDT = 30;
COLOR_HGT = 40;
PALETTE_WDT = COLOR_WDT*32;
PALETTE_HGT = COLOR_HGT*8;
PALETTE_X = (WIN_WDT - PALETTE_WDT) >> 1;
PALETTE_Y = 248;
SLIDER_WDT = 254;
SLIDER_HGT = COLOR_HGT - 2;

PALETTE_BTN_Y = 32;
PALETTE_BTN_MAX = 2;
PALETTE_BTN_SPACING = 0;
PALETTE_BTN_OK = 0;
PALETTE_BTN_CANCEL = 1;


var palette_btn_pos = new Array(TOOLBAR_BTN_MAX);
var palette_btn_label = ['Ok','Cancel'];
var palX;
var palY;
var palLx;
var palLy;

function initPalette() {
	temp=document.getElementById('palette');
	ctxPalette=temp.getContext('2d');
	ctxPalette.canvas.width = WIN_WDT;
	ctxPalette.canvas.height = WIN_HGT;
	ctxPalette.font = 'bold 16px Myriad Pro';
	ctxPalette.textBaseline = 'top';
	drawPalette();
	initPaletteButtons();

	ctxPalette.canvas.addEventListener('mousedown', palette_mousedown, false);
	ctxPalette.canvas.addEventListener('mousemove', palette_mousemove, false);
	ctxPalette.canvas.addEventListener('mouseup', palette_mouseup, false);
	ctxPalette.canvas.addEventListener('touchstart', palette_touchstart, false);
	ctxPalette.canvas.addEventListener('touchmove', palette_touchmove, false);
	ctxPalette.canvas.addEventListener('touchend', palette_touchend, false);
	ctxPalette.canvas.addEventListener('touchcancel', palette_touchend, false);
}

function initPaletteButtons() {
	palette_btn_pos[0] = [600,PALETTE_BTN_Y];
	palette_btn_pos[1] = [720,PALETTE_BTN_Y];
	drawButton(ctxPalette, palette_btn_pos[PALETTE_BTN_OK][0], palette_btn_pos[PALETTE_BTN_OK][1],palette_btn_label[PALETTE_BTN_OK], false);
	drawButton(ctxPalette, palette_btn_pos[PALETTE_BTN_CANCEL][0], palette_btn_pos[PALETTE_BTN_OK][1],palette_btn_label[PALETTE_BTN_CANCEL], false);
}

function drawColor(index) {
	ctxPalette.fillStyle = 'rgb('+paleta[index]+')';
	ctxPalette.fillRect(320,32,128,128);
}

function drawBgColor(index) {
	ctxPalette.fillStyle = 'rgb('+paleta[index]+')';
	ctxPalette.fillRect(368,80,128,128);
}

function drawPalette() {
	pal = 0;
	y = PALETTE_Y;
	for( j=0; j<8; j++ ) {
		x = PALETTE_X;
		for( i=0; i<32; i++ ) {
			ctxPalette.fillStyle = 'rgb('+paleta[pal]+')';
			ctxPalette.fillRect(x, y, COLOR_WDT, COLOR_HGT);
			x += COLOR_WDT;
			pal++;
		}
		y += COLOR_HGT;
	}
	drawBgColor(bgcolorTmp);
	drawColor(colorTmp);
}

function palette_mousedown(event) {
    palette_pressed(event.pageX, event.pageY);
}

function palette_touchstart(event) {
	event.preventDefault();
	var touch = event.changedTouches[0];
	palette_pressed(touch.pageX, touch.pageY);
}

function palette_pressed(x,y) {
	if(x || y) {
		mousedown = true;
		buttonIdx = -1;
		if( inside(x, y, PALETTE_X, PALETTE_Y, PALETTE_WDT, PALETTE_HGT) ) {
			selectColor(x,y);
		} else if( inside(x, y, 368, 160, 128, 48) || inside(x, y, 448, 80, 48, 80) ) {
			swapColors();
		} else {
			for(i=0; i < PALETTE_BTN_MAX; i++) {
				if( inside(x, y, palette_btn_pos[i][0], palette_btn_pos[i][1], BUTTON_WDT, BUTTON_HGT)  ) {
					buttonIdx = i;
					break;
				}
			}
			if( buttonIdx > -1 ) {
				drawButton(ctxPalette, palette_btn_pos[buttonIdx][0], palette_btn_pos[buttonIdx][1], palette_btn_label[buttonIdx], true);
			}
		}
	}
}

function palette_mousemove(event) {
    palette_dragged(event.pageX, event.pageY);
}

function palette_touchmove(event) {
	event.preventDefault();
	var touch = event.changedTouches[0];
	palette_dragged(touch.pageX, touch.pageY);
}

function palette_dragged(x,y) {
	if(x || y) {
		if( mousedown && inside(x, y, PALETTE_X, PALETTE_Y, PALETTE_WDT, PALETTE_HGT) ) {
			selectColor(x,y);
		}
	}
}

function selectColor(x,y) {
	x = Math.floor((x - PALETTE_X) / COLOR_WDT);
	y = Math.floor((y - PALETTE_Y) / COLOR_HGT);
	colorTmp  = (y << 5) | x;
	drawColor(colorTmp);
}

function swapColors() {
	temp = colorTmp;
	colorTmp = bgcolorTmp;
	bgcolorTmp = temp;
	drawBgColor(bgcolorTmp);
	drawColor(colorTmp);
}

function palette_mouseup(event) {
	palette_released(0,0);
}

function palette_touchend(event) {
	palette_released(0,0);
}

function palette_released(x,y) {
	mousedown = false;
	if( buttonIdx > -1 ) {
		drawButton(ctxPalette, palette_btn_pos[buttonIdx][0], palette_btn_pos[buttonIdx][1], palette_btn_label[buttonIdx], false);
		palette_action(buttonIdx);
	}
}

function palette_action(idx) {
	switch(idx) {
		case PALETTE_BTN_OK:
			colorIdx = colorTmp;
			bgcolorIdx = bgcolorTmp;
			ctxSetColor(ctxBrush);
			document.getElementById('palette').style.display = 'none';
		break;
		case PALETTE_BTN_CANCEL:
			drawBgColor(bgcolorIdx);
			drawColor(colorIdx);
			document.getElementById('palette').style.display = 'none';
		break;
	}
}

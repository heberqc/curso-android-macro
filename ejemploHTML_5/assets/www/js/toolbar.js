
/*** TOOLBAR ***/
//la barra superior de botones

TOOLBAR_BTN_Y = 4;
TOOLBAR_BTN_MAX = 7;
TOOLBAR_BTN_SPACING = 0;
TOOLBAR_BTN_NEW = 0;
TOOLBAR_BTN_LOAD = 1;
TOOLBAR_BTN_SAVE = 2;
TOOLBAR_BTN_SHARE = 3
TOOLBAR_BTN_BRUSHES = 4;
TOOLBAR_BTN_COLORS = 5;
TOOLBAR_BTN_HELP = 6;

var toolbar_btn_posx = new Array(TOOLBAR_BTN_MAX);
var toolbar_btn_label = ['New','Open','Save','Share','Brushes','Colors','Help'];

function initToolbar() {
	temp=document.getElementById('toolbar');
	ctxToolbar=temp.getContext('2d');
	ctxToolbar.canvas.width = WIN_WDT;
	ctxToolbar.canvas.height = TOOLBAR_HGT;
	ctxToolbar.canvas.style.background = '#404040';
	ctxToolbar.font = 'bold 16px Myriad Pro';
	ctxToolbar.textBaseline = 'top';
	ctxToolbar.fillStyle = '#000000';
	ctxToolbar.fillRect(0, TOOLBAR_HGT-1, WIN_WDT, TOOLBAR_HGT-1);
	initToolbarButtons();

	ctxToolbar.canvas.addEventListener('mousedown', toolbar_mousedown, false);
	ctxToolbar.canvas.addEventListener('mousemove', toolbar_mousemove, false);
	ctxToolbar.canvas.addEventListener('mouseup', toolbar_mouseup, false);
	ctxToolbar.canvas.addEventListener('touchstart', toolbar_touchstart, false);
	ctxToolbar.canvas.addEventListener("touchmove", toolbar_touchmove, false);
	ctxToolbar.canvas.addEventListener('touchend', toolbar_touchend, false);
}

function initToolbarButtons() {
	free = WIN_WDT - (BUTTON_WDT * TOOLBAR_BTN_MAX);
	margin = (free % (TOOLBAR_BTN_MAX + 1)) >> 1;
	TOOLBAR_BTN_SPACING = Math.floor( free / (TOOLBAR_BTN_MAX + 1) );
	pos = margin + TOOLBAR_BTN_SPACING;
	for(i=0; i<TOOLBAR_BTN_MAX; i++) {
		toolbar_btn_posx[i] = pos;
		pos += (BUTTON_WDT + TOOLBAR_BTN_SPACING);
	}
	drawButton(ctxToolbar, toolbar_btn_posx[TOOLBAR_BTN_NEW], TOOLBAR_BTN_Y, toolbar_btn_label[TOOLBAR_BTN_NEW], false);
	drawButton(ctxToolbar, toolbar_btn_posx[TOOLBAR_BTN_LOAD], TOOLBAR_BTN_Y, toolbar_btn_label[TOOLBAR_BTN_LOAD], false);
	drawButton(ctxToolbar, toolbar_btn_posx[TOOLBAR_BTN_SAVE], TOOLBAR_BTN_Y, toolbar_btn_label[TOOLBAR_BTN_SAVE], false);
	drawButton(ctxToolbar, toolbar_btn_posx[TOOLBAR_BTN_SHARE], TOOLBAR_BTN_Y, toolbar_btn_label[TOOLBAR_BTN_SHARE], false);
	drawButton(ctxToolbar, toolbar_btn_posx[TOOLBAR_BTN_BRUSHES], TOOLBAR_BTN_Y, toolbar_btn_label[TOOLBAR_BTN_BRUSHES], false);
	drawButton(ctxToolbar, toolbar_btn_posx[TOOLBAR_BTN_COLORS], TOOLBAR_BTN_Y, toolbar_btn_label[TOOLBAR_BTN_COLORS], false);
	drawButton(ctxToolbar, toolbar_btn_posx[TOOLBAR_BTN_HELP], TOOLBAR_BTN_Y, toolbar_btn_label[TOOLBAR_BTN_HELP], false);
}

function toolbar_mousedown(event) {
	toolbar_pressed(event.pageX, event.pageY);
}

function toolbar_touchstart(event) {
	event.preventDefault();
	var touch = event.changedTouches[0];
	toolbar_pressed(touch.pageX, touch.pageY);
}

function toolbar_pressed(x,y) {
	mousedown = true;
	buttonIdx = -1;
	for(i=0; i < TOOLBAR_BTN_MAX; i++) {
		if( inside(x, y, toolbar_btn_posx[i], TOOLBAR_BTN_Y, BUTTON_WDT, BUTTON_HGT)  ) {
			buttonIdx = i;
			break;
		}
	}
	if( buttonIdx > -1 ) {
		drawButton(ctxToolbar, toolbar_btn_posx[buttonIdx], TOOLBAR_BTN_Y, toolbar_btn_label[buttonIdx], true);
	}
}

function toolbar_mousemove(event) {
	toolbar_dragged(event.pageX, event.pageY);
}

function toolbar_touchmove(event) {
	if( mousedown ) {
		event.preventDefault();
	    var touch = event.changedTouches[0];
	    toolbar_dragged(touch.pageX, touch.pageY);
	}
}

function toolbar_dragged(x,y) {

}

function toolbar_mouseup(event) {
	toolbar_released(0,0);
}

function toolbar_touchend(event) {
	toolbar_released(0,0);
}

function toolbar_released(x,y) {
	mousedown = false;
	if( buttonIdx > -1 ) {
		drawButton(ctxToolbar, toolbar_btn_posx[buttonIdx], TOOLBAR_BTN_Y, toolbar_btn_label[buttonIdx], false);
		toolbar_action(buttonIdx);
	}
}

function toolbar_action(idx) {
	switch(idx) {
		case TOOLBAR_BTN_NEW:
			ctxCanvas.fillStyle = 'rgb('+paleta[bgcolorIdx]+')';
			ctxCanvas.fillRect( 0, 0, ctxCanvas.canvas.width, ctxCanvas.canvas.height );
			break;
		case TOOLBAR_BTN_SHARE:
			var strDataURI = ctxCanvas.canvas.toDataURL('image/jpeg');
			console.log(strDataURI);
			break;
		case TOOLBAR_BTN_BRUSHES:
			lineTmp = lineWidth;
			document.getElementById('brushes').style.display = 'block';
			break;
		case TOOLBAR_BTN_COLORS:
			colorTmp = colorIdx;
			bgcolorTmp = bgcolorIdx;
			document.getElementById('palette').style.display = 'block';
			break;
	}
}

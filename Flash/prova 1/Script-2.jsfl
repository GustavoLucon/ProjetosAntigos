﻿package {
	import flash.display.*;
	import flash.events.*;
	public class RodaQuadrado extends MovieClip {
		public function RodaQuadrado(iniX,iniY) {
			this.x=iniX;
			this.y=iniY;
			this.addEventListener(MouseEvent.MOUSE_DOWN,mousepressionado);
		}
		public function mousepressionado (event:MouseEvent){
			this.rotation +=5;
		}
	}
} 
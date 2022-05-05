import { ThemableMixin } from '@vaadin/vaadin-themable-mixin/vaadin-themable-mixin.js';
import { badge } from '@vaadin/vaadin-lumo-styles/badge.js';
import { css, unsafeCSS, html, LitElement, } from 'lit';
import { customElement } from 'lit/decorators';

@customElement('tatus-badge')
export class Badge extends ThemableMixin(LitElement) {

  static get is() {
    return 'tatus-badge';
  }

  static get styles() {
	return badge.styleSheet;
  }

  _setTheme(theme : string) {
  }

  render() {
	return html`<span theme='${this.theme}' part='badge'><slot></slot></span>`
  }
}
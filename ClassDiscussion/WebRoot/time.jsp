<div class="rightcontainer">
							<!--登陆信息-->
							<table border="0" cellpadding="0" cellspacing="0" width="100%"
								height="100%">
								<tr>
									<td width="10" height="10"><img src="img/bd1.gif" />
									</td>
									<td width="270" background="img/bd2.gif"></td>
									<td width="10"><img src="img/bd3.gif" />
									</td>
								</tr>
								<tr>
									<td background="img/bd4.gif"></td>
									<td bgcolor="#FFFFFF">
										<div id="loginfo">
											今天是：<br /><%=DateAndTime.getCurrentlyTime()%>
											<br /> 本次登录IP：<br /><%=request.getRemoteAddr()%>
											<br />
											<a href="logOut.action">退出登录</a>
										</div>
										<div id="clock">
											<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
												codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0"
												width="95" height="95">
												<param name="movie" value="swf/clock.swf" />
												<param name="quality" value="high" />
												<embed src="swf/clock.swf" quality="high"
													pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"
													type="application/x-shockwave-flash" width="95" height="95"></embed>
											</object>
										</div></td>
									<td background="img/bd6.gif"></td>
								</tr>
								<tr>
									<td width="10" height="10"><img src="img/bd7.gif" />
									</td>
									<td background="img/bd8.gif"></td>
									<td width="10"><img src="img/bd9.gif" />
									</td>
								</tr>
							</table>
						</div>
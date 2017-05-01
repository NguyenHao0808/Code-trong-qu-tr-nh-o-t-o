package net.luvina.phamthanhluan.cocaro.gentheco;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenTheCo {
	private int[][] theCo = new int[5][5];
	private int iD = 0;
	private int jD = 0;

	/**
	 * gen nước cờ đơn ngang - doc 4x
	 */
	public void genNuocDonND4x() {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo1.txt", true);
			for (int m = 0; m < 5; m++) {
				for (int n = 0; n < 5; n++) {

					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {

							if (i == m) {
								if (j == n) {
									theCo[i][j] = 1;
								} else {
									theCo[i][j] = 2;
								}
							} else {
								theCo[i][j] = 3;
							}
						}

					}
					String[] line = { "", "", "", "", "" };

					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							switch (theCo[i][j]) {
							case 1:
								line[i] = line[i] + "D";
								break;
							case 0:
								line[i] = line[i] + "T";
								break;
							case 2:
								line[i] = line[i] + "X";
								break;
							case 3:
								line[i] = line[i] + "G";
								break;
							default:
								break;
							}

						}
					}

					for (int i = 0; i < 5; i++) {
						fos.write(line[i].getBytes());
						fos.write(13);
						fos.write(10);
					}
					fos.write(13);
					fos.write(10);

				}
				fos.write("-----".getBytes());
				fos.write(13);
				fos.write(10);
				fos.write(13);
				fos.write(10);
			}
			for (int m = 0; m < 5; m++) {
				for (int n = 0; n < 5; n++) {

					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {

							if (j == n) {
								if (i == m) {
									theCo[i][j] = 1;
								} else {
									theCo[i][j] = 2;
								}
							} else {
								theCo[i][j] = 3;
							}
						}

					}
					String[] line = { "", "", "", "", "" };

					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							switch (theCo[i][j]) {
							case 1:
								line[i] = line[i] + "D";
								break;
							case 0:
								line[i] = line[i] + "T";
								break;
							case 2:
								line[i] = line[i] + "X";
								break;
							case 3:
								line[i] = line[i] + "G";
								break;
							default:
								break;
							}

						}
					}

					for (int i = 0; i < 5; i++) {
						fos.write(line[i].getBytes());
						fos.write(13);
						fos.write(10);
					}
					fos.write(13);
					fos.write(10);

				}
				fos.write("-----".getBytes());
				fos.write(13);
				fos.write(10);
				fos.write(13);
				fos.write(10);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đôi ngang - doc 3x1t
	 */
	public void genNuocDoiND() {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo1.txt", true);
			for (int m = 0; m < 5; m++) {
				for (int n = 0; n < 5; n++) {
					if (m == iD || n == jD) {
						continue;
					} else {
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								if (i == iD && j == jD) {
									theCo[i][j] = 1;
								} else {

									if (j == jD) {
										if (i == m) {
											theCo[i][j] = 0;
										} else {
											theCo[i][j] = 2;
										}
									} else {
										if (i == iD) {
											if (j == n) {
												theCo[i][j] = 0;
											} else {
												theCo[i][j] = 2;
											}
										} else {
											theCo[i][j] = 3;
										}
									}

								}

							}
						}
					}
					String[] line = { "", "", "", "", "" };

					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							switch (theCo[i][j]) {
							case 1:
								line[i] = line[i] + "D";
								break;
							case 0:
								line[i] = line[i] + "T";
								break;
							case 2:
								line[i] = line[i] + "X";
								break;
							case 3:
								line[i] = line[i] + "G";
								break;
							default:
								break;
							}

						}
					}
					for (int i = 0; i < 5; i++) {
						fos.write(line[i].getBytes());
						fos.write(13);
						fos.write(10);
					}
					fos.write(13);
					fos.write(10);

				}
				if (m != 2) {
					fos.write("-----".getBytes());
					fos.write(13);
					fos.write(10);
					fos.write(13);
					fos.write(10);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đôi dọc - chéo 3x1t
	 */
	public void genNuocDoiDC() {

		try {
			FileOutputStream fos = new FileOutputStream("TheCo1.txt", true);
			for (int m = 0; m < 5; m++) {
				for (int n = 0; n < 5; n++) {
					if (m == iD || n == jD) {
						continue;
					} else {
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								if (i == iD && j == jD) {
									theCo[i][j] = 1;
								} else {

									if (j == jD) {
										if (i == m) {
											theCo[i][j] = 0;
										} else {
											theCo[i][j] = 2;
										}
									} else {
										if ((i + j) == (iD + jD)) {
											if (j == n) {
												theCo[i][j] = 0;
											} else {
												theCo[i][j] = 2;
											}
										} else {
											theCo[i][j] = 3;
										}
									}

								}

							}
						}
					}
					String[] line = { "", "", "", "", "" };

					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							switch (theCo[i][j]) {
							case 1:
								line[i] = line[i] + "D";
								break;
							case 0:
								line[i] = line[i] + "T";
								break;
							case 2:
								line[i] = line[i] + "X";
								break;
							case 3:
								line[i] = line[i] + "G";
								break;
							default:
								break;
							}

						}
					}
					for (int i = 0; i < 5; i++) {
						fos.write(line[i].getBytes());
						fos.write(13);
						fos.write(10);
					}
					fos.write(13);
					fos.write(10);

				}
				if (m != 2) {
					fos.write("-----".getBytes());
					fos.write(13);
					fos.write(10);
					fos.write(13);
					fos.write(10);
				}

			}

			// Hàng dọc và đường chéo chính
			for (int m = 0; m < 5; m++) {
				for (int n = 0; n < 5; n++) {
					if (m == (4 - iD) || n == jD) {
						continue;
					} else {
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								if (i == (4 - iD) && j == jD) {
									theCo[i][j] = 1;
								} else {

									if (j == jD) {
										if (i == m) {
											theCo[i][j] = 0;
										} else {
											theCo[i][j] = 2;
										}
									} else {
										if (i == j) {
											if (j == n) {
												theCo[i][j] = 0;
											} else {
												theCo[i][j] = 2;
											}
										} else {
											theCo[i][j] = 3;
										}
									}

								}

							}
						}
					}
					String[] line = { "", "", "", "", "" };

					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							switch (theCo[i][j]) {
							case 1:
								line[i] = line[i] + "D";
								break;
							case 0:
								line[i] = line[i] + "T";
								break;
							case 2:
								line[i] = line[i] + "X";
								break;
							case 3:
								line[i] = line[i] + "G";
								break;
							default:
								break;
							}

						}
					}
					for (int i = 0; i < 5; i++) {
						fos.write(line[i].getBytes());
						fos.write(13);
						fos.write(10);
					}
					fos.write(13);
					fos.write(10);

				}
				if (m != 2) {
					fos.write("-----".getBytes());
					fos.write(13);
					fos.write(10);
					fos.write(13);
					fos.write(10);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đơn 3x2t
	 */
	public void genNuocDon3x2T() {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo1.txt", true);
			for (int m = 0; m < 5; m++) {
				for (int n = 1; n < 5; n++) {

					for (int o = 0; o < n; o++) {

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {

								if (i == m) {
									if (n == 4) {
										if (j == n) {
											theCo[i][j] = 0;
										} else {
											if (j == o) {
												theCo[i][j] = 1;
											} else {
												theCo[i][j] = 2;
											}
										}
									} else {
										if ((4 - n) > o) {
											if (j == n) {
												theCo[i][j] = 1;
											} else {
												if (j == o) {
													theCo[i][j] = 0;
												} else {
													theCo[i][j] = 2;
												}
											}
										} else {
											if (j == n) {
												theCo[i][j] = 0;
											} else {
												if (j == o) {
													theCo[i][j] = 1;
												} else {
													theCo[i][j] = 2;
												}
											}
										}
									}
								} else {
									theCo[i][j] = 3;
								}
							}

						}
						String[] line = { "", "", "", "", "" };

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								switch (theCo[i][j]) {
								case 1:
									line[i] = line[i] + "D";
									break;
								case 0:
									line[i] = line[i] + "T";
									break;
								case 2:
									line[i] = line[i] + "X";
									break;
								case 3:
									line[i] = line[i] + "G";
									break;
								default:
									break;
								}

							}
						}

						for (int i = 0; i < 5; i++) {
							fos.write(line[i].getBytes());
							fos.write(13);
							fos.write(10);
						}
						fos.write(13);
						fos.write(10);

					}
					fos.write("-----".getBytes());
					fos.write(13);
					fos.write(10);
					fos.write(13);
					fos.write(10);
				}
			}

			// hàng dọc

			for (int m = 0; m < 5; m++) {
				for (int n = 1; n < 5; n++) {

					for (int o = 0; o < m; o++) {

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {

								if (j == n) {
									if (m == 4) {
										if (i == m) {
											theCo[i][j] = 0;
										} else {
											if (i == o) {
												theCo[i][j] = 1;
											} else {
												theCo[i][j] = 2;
											}
										}
									} else {
										if ((4 - m) > o) {
											if (i == m) {
												theCo[i][j] = 1;
											} else {
												if (i == o) {
													theCo[i][j] = 0;
												} else {
													theCo[i][j] = 2;
												}
											}
										} else {
											if (i == m) {
												theCo[i][j] = 0;
											} else {
												if (i == o) {
													theCo[i][j] = 1;
												} else {
													theCo[i][j] = 2;
												}
											}
										}
									}
								} else {
									theCo[i][j] = 3;
								}
							}

						}
						String[] line = { "", "", "", "", "" };

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								switch (theCo[i][j]) {
								case 1:
									line[i] = line[i] + "D";
									break;
								case 0:
									line[i] = line[i] + "T";
									break;
								case 2:
									line[i] = line[i] + "X";
									break;
								case 3:
									line[i] = line[i] + "G";
									break;
								default:
									break;
								}

							}
						}

						for (int i = 0; i < 5; i++) {
							fos.write(line[i].getBytes());
							fos.write(13);
							fos.write(10);
						}
						fos.write(13);
						fos.write(10);

					}
					fos.write("-----".getBytes());
					fos.write(13);
					fos.write(10);
					fos.write(13);
					fos.write(10);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đôi ngang - doc 2x2t
	 */
	public void genNuocDoiND2x2T() {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo2.txt", true);
			for (int m = 0; m < 5; m++) {
				if (m == iD) {
					continue;
				}
				for (int n = 0; n < 5; n++) {
					if (n == jD) {
						continue;
					} else {
						for (int p = m + 1; p < 5; p++) {
							for (int q = n + 1; q < 5; q++) {
								for (int i = 0; i < 5; i++) {
									for (int j = 0; j < 5; j++) {

										if (i != iD || j != jD) {
											if (i == iD) {
												if (j == n || j == q) {
													theCo[i][j] = 0;
												} else {
													theCo[i][j] = 2;
												}
											} else {
												if (j == jD) {
													if (i == m || i == p) {
														theCo[i][j] = 0;

													} else {
														theCo[i][j] = 2;
													}
												} else {
													theCo[i][j] = 3;
												}
											}

										} else {
											theCo[i][j] = 1;
										}

									}
								}
								String[] line = { "", "", "", "", "" };

								for (int i = 0; i < 5; i++) {
									for (int j = 0; j < 5; j++) {
										switch (theCo[i][j]) {
										case 1:
											line[i] = line[i] + "D";
											break;
										case 0:
											line[i] = line[i] + "T";
											break;
										case 2:
											line[i] = line[i] + "X";
											break;
										case 3:
											line[i] = line[i] + "G";
											break;
										default:
											break;
										}

									}
								}
								for (int i = 0; i < 5; i++) {
									fos.write(line[i].getBytes());
									fos.write(13);
									fos.write(10);
								}
								fos.write(13);
								fos.write(10);

							}

						}

					}
				}

			}

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đôi ngang - chéo 2x2t
	 */
	public void genNuocDoiNC2x2T() {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo2.txt", true);
			for (int m = 0; m < 5; m++) {
				if (m == iD) {
					continue;
				}
				for (int n = 0; n < 5; n++) {
					if (n == jD) {
						continue;
					} else {
						for (int p = m + 1; p < 5; p++) {
							for (int q = n + 1; q < 5; q++) {
								for (int i = 0; i < 5; i++) {
									for (int j = 0; j < 5; j++) {

										if (i != iD || j != jD) {
											if (i == iD) {
												if (j == n || j == q) {
													theCo[i][j] = 0;
												} else {
													theCo[i][j] = 2;
												}
											} else {
												if (iD == jD) {
													if (i == j) {
														if (i == p || i == m) {
															theCo[i][j] = 0;
														} else {
															theCo[i][j] = 2;
														}
													} else {
														theCo[i][j] = 3;
													}
												}

												if ((iD + jD) == 4) {
													if ((i + j) == 4) {
														if (j == q || j == n) {

															theCo[i][j] = 0;

														} else {
															theCo[i][j] = 2;
														}
													} else {
														theCo[i][j] = 3;
													}
												}
											}

										} else {
											theCo[i][j] = 1;
										}

									}
								}
								String[] line = { "", "", "", "", "" };

								for (int i = 0; i < 5; i++) {
									for (int j = 0; j < 5; j++) {
										switch (theCo[i][j]) {
										case 1:
											line[i] = line[i] + "D";
											break;
										case 0:
											line[i] = line[i] + "T";
											break;
										case 2:
											line[i] = line[i] + "X";
											break;
										case 3:
											line[i] = line[i] + "G";
											break;
										default:
											break;
										}

									}
								}
								for (int i = 0; i < 5; i++) {
									fos.write(line[i].getBytes());
									fos.write(13);
									fos.write(10);
								}
								fos.write(13);
								fos.write(10);

							}

						}

					}
				}

			}

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đôi doc - chéo 2x2t
	 */
	public void genNuocDoiDC2x2T() {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo2.txt", true);
			for (int m = 0; m < 5; m++) {
				if (m == iD) {
					continue;
				}
				for (int n = 0; n < 5; n++) {
					if (n == jD) {
						continue;
					} else {
						for (int p = m + 1; p < 5; p++) {
							for (int q = n + 1; q < 5; q++) {
								for (int i = 0; i < 5; i++) {
									for (int j = 0; j < 5; j++) {

										if (i != iD || j != jD) {
											if (j == jD) {
												if (i == m || i == p) {
													theCo[i][j] = 0;
												} else {
													theCo[i][j] = 2;
												}
											} else {
												if (iD == jD) {
													if (i == j) {
														if (j == q || j == n) {
															theCo[i][j] = 0;
														} else {
															theCo[i][j] = 2;
														}
													} else {
														theCo[i][j] = 3;
													}
												}

												if ((iD + jD) == 4) {
													if ((i + j) == 4) {
														if (j == q || j == n) {

															theCo[i][j] = 0;

														} else {
															theCo[i][j] = 2;
														}
													} else {
														theCo[i][j] = 3;
													}
												}
											}

										} else {
											theCo[i][j] = 1;
										}

									}
								}
								String[] line = { "", "", "", "", "" };

								for (int i = 0; i < 5; i++) {
									for (int j = 0; j < 5; j++) {
										switch (theCo[i][j]) {
										case 1:
											line[i] = line[i] + "D";
											break;
										case 0:
											line[i] = line[i] + "T";
											break;
										case 2:
											line[i] = line[i] + "X";
											break;
										case 3:
											line[i] = line[i] + "G";
											break;
										default:
											break;
										}

									}
								}
								for (int i = 0; i < 5; i++) {
									fos.write(line[i].getBytes());
									fos.write(13);
									fos.write(10);
								}
								fos.write(13);
								fos.write(10);

							}

						}

					}
				}

			}

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đơn phát triển 3x2t
	 */
	public void genNuocDonPT3x2T() {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo1.txt", true);
			for (int m = 0; m < 5; m++) {
				for (int n = 2; n < 5; n++) {

					for (int o = 1; o < n; o++) {

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {

								if (i == m) {
									if (n == 4) {
										if (j == n) {
											theCo[i][j] = 0;
										} else {
											if (j == o) {
												theCo[i][j] = 1;
											} else {
												theCo[i][j] = 2;
											}
										}
									} else {
										if ((4 - n) > o) {
											if (j == n) {
												theCo[i][j] = 1;
											} else {
												if (j == o) {
													theCo[i][j] = 0;
												} else {
													theCo[i][j] = 2;
												}
											}
										} else {
											if (j == n) {
												theCo[i][j] = 0;
											} else {
												if (j == o) {
													theCo[i][j] = 1;
												} else {
													theCo[i][j] = 2;
												}
											}
										}
									}
								} else {
									theCo[i][j] = 3;
								}
							}

						}
						String[] line = { "", "", "", "", "" };

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								switch (theCo[i][j]) {
								case 1:
									line[i] = line[i] + "D";
									break;
								case 0:
									line[i] = line[i] + "T";
									break;
								case 2:
									line[i] = line[i] + "X";
									break;
								case 3:
									line[i] = line[i] + "G";
									break;
								default:
									break;
								}

							}
						}

						for (int i = 0; i < 5; i++) {
							fos.write(line[i].getBytes());
							fos.write(13);
							fos.write(10);
						}
						fos.write(13);
						fos.write(10);

					}
					fos.write("-----".getBytes());
					fos.write(13);
					fos.write(10);
					fos.write(13);
					fos.write(10);
				}
			}

			// hàng dọc

			for (int m = 0; m < 5; m++) {
				for (int n = 2; n < 5; n++) {

					for (int o = 1; o < m; o++) {

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {

								if (j == n) {
									if (m == 4) {
										if (i == m) {
											theCo[i][j] = 0;
										} else {
											if (i == o) {
												theCo[i][j] = 1;
											} else {
												theCo[i][j] = 2;
											}
										}
									} else {
										if ((4 - m) > o) {
											if (i == m) {
												theCo[i][j] = 1;
											} else {
												if (i == o) {
													theCo[i][j] = 0;
												} else {
													theCo[i][j] = 2;
												}
											}
										} else {
											if (i == m) {
												theCo[i][j] = 0;
											} else {
												if (i == o) {
													theCo[i][j] = 1;
												} else {
													theCo[i][j] = 2;
												}
											}
										}
									}
								} else {
									theCo[i][j] = 3;
								}
							}

						}
						String[] line = { "", "", "", "", "" };

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								switch (theCo[i][j]) {
								case 1:
									line[i] = line[i] + "D";
									break;
								case 0:
									line[i] = line[i] + "T";
									break;
								case 2:
									line[i] = line[i] + "X";
									break;
								case 3:
									line[i] = line[i] + "G";
									break;
								default:
									break;
								}

							}
						}

						for (int i = 0; i < 5; i++) {
							fos.write(line[i].getBytes());
							fos.write(13);
							fos.write(10);
						}
						fos.write(13);
						fos.write(10);

					}
					fos.write("-----".getBytes());
					fos.write(13);
					fos.write(10);
					fos.write(13);
					fos.write(10);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đôi ngang - doc 3x2t - 2x3t
	 */
	public void genNuocDoiND3X2T_2X3T(int iD, int jD) {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo1.txt", true);
			for (int m = 1; m < 5; m++) {
				for (int n = 1; n < 5; n++) {
					if (m == iD || n == jD ) {
						continue;
					} else {

						// N-D

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								if (i == iD && j == jD) {
									theCo[i][j] = 1;
								} else {
									if ((i == 0 && j == jD) || (i == iD && j == 0)) {
										theCo[i][j] = 0;
									} else {

										if (j == jD) {
											if (i == m) {
												theCo[i][j] = 0;
											} else {
												theCo[i][j] = 2;
											}
										} else {
											if (i == iD) {
												theCo[i][j] = 2;
											} else {
												theCo[i][j] = 3;
											}
										}
									}

								}

							}
						}
						String[] line = { "", "", "", "", "" };

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								switch (theCo[i][j]) {
								case 1:
									line[i] = line[i] + "D";
									break;
								case 0:
									line[i] = line[i] + "T";
									break;
								case 2:
									line[i] = line[i] + "X";
									break;
								case 3:
									line[i] = line[i] + "G";
									break;
								default:
									break;
								}

							}
						}
						for (int i = 0; i < 5; i++) {
							fos.write(line[i].getBytes());
							fos.write(13);
							fos.write(10);
						}
						fos.write(13);
						fos.write(10);

					}

				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * gen nước cờ đôi doc - ngang 3x2t - 2x3t
	 */
	public void genNuocDoiDN3X2T_2X3T(int iD, int jD) {
		try {
			FileOutputStream fos = new FileOutputStream("TheCo1.txt", true);
			for (int m = 1; m < 5; m++) {
				for (int n = 1; n < 5; n++) {
					if (m == iD || n == jD ) {
						continue;
					} else {

						// N-D

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								if (i == iD && j == jD) {
									theCo[i][j] = 1;
								} else {
									if ((i == 0 && j == jD) || (i == iD && j == 0)) {
										theCo[i][j] = 0;
									} else {

										if (i == iD) {
											if (j == n) {
												theCo[i][j] = 0;
											} else {
												theCo[i][j] = 2;
											}
										} else {
											if (j == jD) {
												theCo[i][j] = 2;
											} else {
												theCo[i][j] = 3;
											}
										}
									}

								}

							}
						}
						String[] line = { "", "", "", "", "" };

						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								switch (theCo[i][j]) {
								case 1:
									line[i] = line[i] + "D";
									break;
								case 0:
									line[i] = line[i] + "T";
									break;
								case 2:
									line[i] = line[i] + "X";
									break;
								case 3:
									line[i] = line[i] + "G";
									break;
								default:
									break;
								}

							}
						}
						for (int i = 0; i < 5; i++) {
							fos.write(line[i].getBytes());
							fos.write(13);
							fos.write(10);
						}
						fos.write(13);
						fos.write(10);

					}

				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	
	public static void main(String[] args) {
		GenTheCo genTheCo = new GenTheCo();
		// genTheCo.genNuocDoiND();
		// genTheCo.genNuocDonND4x();
		// genTheCo.genNuocDoiDC();
		// genTheCo.genNuocDon3x2T();
		// genTheCo.genNuocDoiND2x2T();
		// genTheCo.genNuocDoiNC2x2T();
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 5; j++) {
				genTheCo.genNuocDoiDN3X2T_2X3T(j, i);
			}
		}

	}

}

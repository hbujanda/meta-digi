SUMMARY = "Digi's framebuffer test utility"
SECTION = "base"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR = "r0"

DEPENDS = "microwindows"

FILESEXTRAPATHS_append := "${THISDIR}/files:"
SRC_URI = "file://fbtest.c \
           "

S = "${WORKDIR}"

do_compile() {
	${CC} -O2 -Wall -I usr/include/ -L usr/lib fbtest.c -lnano-X -o fbtest
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 fbtest ${D}${bindir}
}
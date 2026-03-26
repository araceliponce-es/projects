#!/usr/bin/env bash

set -e

# INPUT_DIR="input"
INPUT_DIR="Taceboke\Tacebook\src\tacebook\img"
# OUTPUT_DIR="output"
OUTPUT_DIR="Taceboke\Tacebook\src\tacebook\images"
FFMPEG_DIR="ffmpeg"
FFMPEG_BIN="$FFMPEG_DIR/ffmpeg"

WIDTH=20
HEIGHT=20

mkdir -p "$OUTPUT_DIR"
mkdir -p "$FFMPEG_DIR"

# Detect OS
OS="$(uname -s)"

download_ffmpeg_linux() {
    echo "Downloading FFmpeg for Linux..."
    curl -L https://johnvansickle.com/ffmpeg/releases/ffmpeg-release-amd64-static.tar.xz -o ffmpeg.tar.xz
    tar -xf ffmpeg.tar.xz
    mv ffmpeg-*-amd64-static/ffmpeg "$FFMPEG_BIN"
    chmod +x "$FFMPEG_BIN"
    rm -rf ffmpeg-*-amd64-static ffmpeg.tar.xz
}

download_ffmpeg_windows() {
    echo "Downloading FFmpeg for Windows..."
    curl -L https://www.gyan.dev/ffmpeg/builds/ffmpeg-release-essentials.zip -o ffmpeg.zip
    unzip ffmpeg.zip
    mv ffmpeg-*/bin/ffmpeg.exe "$FFMPEG_BIN.exe"
    rm -rf ffmpeg-* ffmpeg.zip
}

# Check FFmpeg
if [ ! -f "$FFMPEG_BIN" ] && [ ! -f "$FFMPEG_BIN.exe" ]; then
    if [[ "$OS" == "Linux"* ]]; then
        download_ffmpeg_linux
    elif [[ "$OS" == "MINGW"* ]] || [[ "$OS" == "MSYS"* ]]; then
        download_ffmpeg_windows
    else
        echo "Unsupported OS: $OS"
        exit 1
    fi
fi

# Choose correct binary
if [ -f "$FFMPEG_BIN" ]; then
    FFMPEG="$FFMPEG_BIN"
else
    FFMPEG="$FFMPEG_BIN.exe"
fi

echo "Using FFmpeg: $FFMPEG"

# Process images
for img in "$INPUT_DIR"/*; do
    filename=$(basename "$img")
    output="$OUTPUT_DIR/$filename"

    echo "Processing $filename..."

    "$FFMPEG" -y -i "$img" \
        -vf "scale=${WIDTH}:${HEIGHT}:force_original_aspect_ratio=decrease,pad=${WIDTH}:${HEIGHT}:(ow-iw)/2:(oh-ih)/2" \
        "$output"
done

echo "Done."
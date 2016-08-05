var gulp = require('gulp'),
    imagemin = require('gulp-imagemin'),
    pngquant = require('imagemin-pngquant'),
    mozjpeg = require('imagemin-mozjpeg'),
    minifyCss = require('gulp-minify-css'),
    uglifyJs = require('gulp-uglify'),
    rev = require('gulp-rev'),
    revReplace = require('gulp-rev-replace'),

    releaseTemplatePath = '/home/daizhan/projects/release/meila_web/',
    releaseStaticPath = '/home/daizhan/projects/release/meila_web/',
    projectPath = '/home/daizhan/projects/meila_web/',
    manifestPath = "/home/daizhan/projects/release/manifest/", 
    template = 'templates/',
    resource = 'resource/',
    filter = {
        jsFiles: '**/*.js',
        cssFiles: '**/*.css',
        imgFiles: '**/*.@(gif|png|jpg|jpeg|svg|mp3|wav)',
        htmlFiles: '**/*.html',
        cacheFiles: '**/*.appcache'
    };

gulp.task('compress:img', function(){
    var resourcePath = releaseStaticPath + resource,
        originalImg = projectPath + resource + filter.imgFiles;

    return gulp.src(originalImg)
               // .pipe(changed(resourcePath)) // 筛选变动的文件
               .pipe(imagemin({
                   interlaced: true,
                   progressive: true,
                   use: [mozjpeg({quality: 95}), pngquant()] 
               }))
               .pipe(gulp.dest(resourcePath));
});
gulp.task('rev:img', ["compress:img"], function(){
    var resourcePath = releaseStaticPath + resource,
        compressedImg = resourcePath + filter.imgFiles;

    return gulp.src(compressedImg)
               .pipe(rev())
               .pipe(gulp.dest(resourcePath))
               .pipe(rev.manifest("img-manifest.json"))
               .pipe(gulp.dest(manifestPath));
});

gulp.task('compress:css', function(){
    var resourcePath = releaseStaticPath + resource,
        originalCss = projectPath + resource + filter.cssFiles;

    return gulp.src([originalCss])
               // .pipe(changed(resourcePath))
               .pipe(minifyCss())
               .pipe(gulp.dest(resourcePath));
});

gulp.task('replace:css-img', ['compress:css', 'rev:img'], function(){
    var resourcePath = releaseStaticPath + resource,
        imgManifest = gulp.src(manifestPath+'img-manifest.json'); 

    return gulp.src(resourcePath + filter.cssFiles)
               .pipe(revReplace({manifest: imgManifest}))
               .pipe(gulp.dest(resourcePath));
});

gulp.task('rev:css', ['replace:css-img'], function(){
    var resourcePath = releaseStaticPath + resource,
        replacedCss = resourcePath + filter.cssFiles;

    return gulp.src([replacedCss])
               .pipe(rev())
               .pipe(gulp.dest(resourcePath))
               .pipe(rev.manifest("css-manifest.json"))
               .pipe(gulp.dest(manifestPath));
});

gulp.task('replace:css', ['rev:css'], function(){
    var resourcePath = releaseStaticPath + resource,
        cssManifest = gulp.src(manifestPath+'css-manifest.json'); 

    return gulp.src(resourcePath + filter.cssFiles)
               .pipe(revReplace({manifest: cssManifest}))
               .pipe(gulp.dest(resourcePath));
});

gulp.task('compress:js', function(){
    var resourcePath = releaseStaticPath + resource,
        originalJs = projectPath + resource + filter.jsFiles;

    return gulp.src([originalJs])
               // .pipe(changed(resourcePath))
               .pipe(uglifyJs())
               .pipe(gulp.dest(resourcePath));
});

gulp.task('replace:js-css-img', ['replace:css', 'compress:js'], function(){
    var resourcePath = releaseStaticPath + resource,
        cssManifest = gulp.src(manifestPath+'css-manifest.json'),
        imgManifest = gulp.src(manifestPath+'img-manifest.json'); 
    return gulp.src(resourcePath + filter.jsFiles)
               .pipe(revReplace({manifest: cssManifest}))
               .pipe(revReplace({manifest: imgManifest}))
               .pipe(gulp.dest(resourcePath));
});

gulp.task('rev:js', ['replace:js-css-img'], function(){
    var resourcePath = releaseStaticPath + resource,
        replacedJs = resourcePath + filter.jsFiles;

    return gulp.src([replacedJs])
               .pipe(rev())
               .pipe(gulp.dest(resourcePath))
               .pipe(rev.manifest("js-manifest.json"))
               .pipe(gulp.dest(manifestPath));
});

gulp.task('replace:js', ['rev:js'], function(){
    var resourcePath = releaseStaticPath + resource,
        jsManifest = gulp.src(manifestPath+'js-manifest.json'); 

    return gulp.src(resourcePath + filter.jsFiles)
               .pipe(revReplace({manifest: jsManifest}))
               .pipe(gulp.dest(resourcePath));
});

gulp.task('replace:html', ['replace:js'], function(){
    var originalHtml = projectPath + template + filter.htmlFiles; 
        cssManifest = gulp.src(manifestPath+'css-manifest.json'),
        jsManifest = gulp.src(manifestPath+'js-manifest.json'), 
        imgManifest = gulp.src(manifestPath+'img-manifest.json'); 
    return gulp.src([originalHtml])
               .pipe(revReplace({manifest: jsManifest}))
               .pipe(revReplace({manifest: cssManifest}))
               .pipe(revReplace({manifest: imgManifest}))
               .pipe(gulp.dest(releaseTemplatePath + template));
});

gulp.task('default', ['replace:html'], function(){});

Dir.glob("src/**/*")
    .select {|f| File.file?(f)} # ignore directories
    .each {|f|
      lines = File.read(f)
                  .lines
                  .map {|line|
                    if line.strip.start_with? "// JC"
                      "" # no line break removes line
                    else
                      line # keeps line with line break
                    end}
      File.open(f, "w") do |x|
        lines.each do |line|
          x << line
        end
      end
    }

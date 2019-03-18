all_comparisons = File.read("comparisons.txt").lines.map(&:strip)

used_comparisons = Dir.glob("src/**/*")
                       .select {|f| File.file?(f)}
                       .map {|f| File.read(f)
                                     .lines
                                     .select {|line| line.strip.start_with? "// JC"}
                                     .map(&:strip)
                                     .map {|line| line[6..-1]}
                       }.flatten

unused_comparisons = all_comparisons - used_comparisons

puts "#{unused_comparisons.size} unused comparisons out of #{all_comparisons.size}"
puts unused_comparisons.sort